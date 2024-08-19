package com.base;

import com.base.entities.PermissionEntity;
import com.base.entities.RoleEntity;
import com.base.entities.UserEntity;
import com.base.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.Set;

@SpringBootApplication
@Slf4j
@EnableJpaAuditing
public class BaseApplication {

	public static void main(String[] args) {
		log.info("Init App Spring Boot");
		SpringApplication.run(BaseApplication.class, args);
	}
	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			log.warn("Creating data in DB, permissions, roles and users");
			/* Create PERMISSIONS */
			PermissionEntity createTest = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readTest = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updateTest = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deleteTest = PermissionEntity.builder()
					.name("DELETE")
					.build();

			PermissionEntity allTest = PermissionEntity.builder()
					.name("READ_ALL")
					.build();

			//
			PermissionEntity allPermission = PermissionEntity.builder()
					.name("READ_ALL_PERMISSION")
					.build();
			//
			PermissionEntity createUser = PermissionEntity.builder()
					.name("CREATE_USER")
					.build();

			PermissionEntity readUser = PermissionEntity.builder()
					.name("READ_USER")
					.build();

			PermissionEntity updateUser = PermissionEntity.builder()
					.name("UPDATE_USER")
					.build();

			PermissionEntity deleteUser = PermissionEntity.builder()
					.name("DELETE_USER")
					.build();

			PermissionEntity allUser = PermissionEntity.builder()
					.name("READ_ALL_USER")
					.build();
			//
			PermissionEntity createProject = PermissionEntity.builder()
					.name("CREATE_PROJECT")
					.build();

			PermissionEntity readProject = PermissionEntity.builder()
					.name("READ_PROJECT")
					.build();

			PermissionEntity updateProject = PermissionEntity.builder()
					.name("UPDATE_PROJECT")
					.build();

			PermissionEntity deleteProject = PermissionEntity.builder()
					.name("DELETE_PROJECT")
					.build();

			PermissionEntity allProject = PermissionEntity.builder()
					.name("READ_ALL_PROJECT")
					.build();
			//
			PermissionEntity createRole = PermissionEntity.builder()
					.name("CREATE_ROLE")
					.build();

			PermissionEntity readRole = PermissionEntity.builder()
					.name("READ_ROLE")
					.build();

			PermissionEntity updateRole = PermissionEntity.builder()
					.name("UPDATE_ROLE")
					.build();

			PermissionEntity deleteRole = PermissionEntity.builder()
					.name("DELETE_ROLE")
					.build();

			PermissionEntity allRole = PermissionEntity.builder()
					.name("READ_ALL_ROLE")
					.build();

			/* Create ROLES */
			RoleEntity roleAdmin = RoleEntity.builder()
					.name("ADMIN")
					.permissionList(Set.of(
							createTest, readTest, updateTest, deleteTest, allTest,
							allPermission,
							updateUser, createUser, readUser, allUser, deleteUser,
							updateProject, createProject, readProject,allProject, deleteProject,
							updateRole, createRole, readRole, allRole, deleteRole))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.name("USER")
					.permissionList(Set.of(createTest, readTest, updateTest, deleteTest, allTest))
					.build();



			/* CREATE USERS */
			UserEntity userAdmin = UserEntity.builder()
					.username("admin")
					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userUser = UserEntity.builder()
					.username("user")
					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			userRepository.saveAll(List.of(userAdmin, userUser));
		};
	}
}
