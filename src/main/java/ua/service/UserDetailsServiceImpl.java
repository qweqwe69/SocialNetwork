package ua.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.repository.UserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		if (!login.equals("admin")) {
			ua.entity.User user = null;
			user = userRepository.findByPhone(login);
			if (user == null) {
				user = userRepository.findByEmail(login);
			}
			if (user == null) {
				return null;
			}
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
			return new User(String.valueOf(user.getId()), user.getPassword(),authorities);
		} else {
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_SUPER_ADMIN"));
			return new User(String.valueOf(0), encoder.encode("admin"),
					authorities);
		}
	}
}
