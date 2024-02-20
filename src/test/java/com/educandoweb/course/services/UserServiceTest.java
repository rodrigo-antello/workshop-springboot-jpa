package com.educandoweb.course.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

	private static final Long ID = 1L;

	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository userRepository;

	User user;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		createUser();
	}

	@Test
	void testFindAll() {
	}

	@Test
	void testFindById() {
		when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
		
		User result = userService.findById(ID);
		
		assertThat(result).isNotNull();
		
		assertThat(result.getClass()).isEqualTo(User.class);
		
		assertThat(result.getName()).isEqualTo("Leona Heidern");
	}

	@Test
	void testInsert() {
	}

	@Test
	void testDelete() {
	}

	@Test
	void testUpdate() {
	}

	private void createUser() {
		user = new User(ID, "Leona Heidern", "leona@kof.com", "2199998-2002", "123456");
	}

}
