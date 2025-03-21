package kr.co.samsami_service_desk

import net.datafaker.Faker
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.sql.DriverManager

@SpringBootApplication
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)

	val faker = Faker()
	val url = "jdbc:log4jdbc:postgresql://localhost:5432/postgres"
	val user = "postgres"
	val password = "1234"

	DriverManager.getConnection(url, user, password).use { conn ->
		val sql = "INSERT INTO tbl_notice (id, title, content, created_at, updated_at, writer_email) VALUES (?, ?, ?, ?, ?, ?) ON CONFLICT (id) DO NOTHING"
		conn.prepareStatement(sql).use { stmt ->
			for (i in 1..2) {
				stmt.setInt(1, i)
				stmt.setString(2, faker.dog().name())
				stmt.setString(3, faker.dog().sound())
				stmt.setTimestamp(4, faker.date().birthday())
				stmt.setTimestamp(5, faker.date().birthday())
				stmt.setString(6, "test1@test.com")
				stmt.executeUpdate()
			}
			stmt.close()
		}
		conn.close()
	}
}
