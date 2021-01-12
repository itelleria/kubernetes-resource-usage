package eu.arima.kubernetesdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
public class KubernetesDemoApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(KubernetesDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KubernetesDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Available CPU Cores: " + Runtime.getRuntime().availableProcessors());
	}

	@RestController
	public static class DemoController {

		@GetMapping("/prime")
		String doSomething(@RequestParam("max") int max) {
			LOGGER.info("Updated CPU Cores: " + Runtime.getRuntime().availableProcessors());
			return calculatePrimeValues(max);
		}

		private String calculatePrimeValues(int max) {
			String result = "";

			for (int i = 1; i <= max; i++) {
				if (checkPrime(i)) {
					result = result + i + " ";
				}
			}

        	return result;
		}

		public static boolean checkPrime(int numberToCheck) {
			int remainder;

			for (int i = 2; i <= numberToCheck / 2; i++) {
				remainder = numberToCheck % i;
				//if remainder is 0 than numberToCheckber is not prime and break loop. Elese continue loop
				if (remainder == 0) {
					return false;
				}
			}
			return true;

		}

	}
}
