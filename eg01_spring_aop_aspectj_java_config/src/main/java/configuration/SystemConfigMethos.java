package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dev.springaop.repository.SimpleRepository;
import com.dev.springaop.repository.SimpleRepositoryImpl;
import com.dev.springaop.service.SimpleService;

@Configuration
public class SystemConfigMethos {
	@Bean
	public SimpleService service() {
		return new SimpleService();
	}
	@Bean
	public SimpleRepository repository() {
		return new SimpleRepositoryImpl();
	}

}
