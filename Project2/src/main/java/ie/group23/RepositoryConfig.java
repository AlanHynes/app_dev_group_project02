package ie.group23;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import ie.group23.domain.Users;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Users.class);
	}
}
