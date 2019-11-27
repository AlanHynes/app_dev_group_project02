package ie.group23;

import org.springframework.context.annotation.Configuration;

import ie.group23.domain.Users;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Users.class);
	}
}
