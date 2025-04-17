# 🏥 Spring Boot - Application de gestion des patients

Ce projet est une application Web basée sur **Spring Boot**, **Spring MVC**, **Thymeleaf** et **Spring Data JPA**.  
Elle permet de gérer les patients via une interface web conviviale avec pagination, recherche, suppression et sécurité.

---

## 🛠️ Technologies utilisées

- Java 17+
- Spring Boot 3.2+
- Spring MVC
- Spring Data JPA
- Thymeleaf
- Spring Security
- H2 Database
- Maven

---

## 📚 Consignes de travail

- 🔗 Créer un **repository GitHub**
- 📥 Déposer **le lien du repository comme livrable** sur Classroom
- 🔁 Faire un **commit/push toutes les 30 minutes**
- 📄 Utiliser ce fichier `README.md` comme **rapport**
- ✅ À la fin de la séance, **faire un dernier commit**
- 🔧 Continuer à **améliorer le projet après la séance**

---

## 🚀 Fonctionnalités

### 🧍 Partie 1 - Gestion des patients 📺

- Afficher la liste des patients
- Pagination
- Recherche de patients
- Suppression d’un patient
- Possibilité d’ajouter d'autres améliorations (Tri, UI, etc.)

---

### 🎨 Partie 2 - Formulaires et Templates 📺

- Création de pages avec **Thymeleaf**
- Validation des formulaires avec messages d’erreur

---

### 🔐 Partie 3 - Sécurité avec Spring Security

#### 1️⃣ InMemory Authentication  
📺 [Vidéo](https://www.youtube.com/watch?v=7VqpC8UD1zM)

#### 2️⃣ JDBC Authentication  
📺 [Vidéo](https://www.youtube.com/watch?v=Haz3wLiQ5-0)

#### 3️⃣ UserDetailsService  
📺 [Vidéo](https://www.youtube.com/watch?v=RTiS9ygyYs4)

---

### 🛡️ Exemple de configuration Spring Security (Spring Boot 3.2+)

```
@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder){
    String encodedPassword = passwordEncoder.encode("1234");
    System.out.println(encodedPassword);
    return new InMemoryUserDetailsManager(
      User.withUsername("user1").password(encodedPassword).roles("USER").build(),
      User.withUsername("user2").password(encodedPassword).roles("USER").build(),
      User.withUsername("admin").password(encodedPassword).roles("USER", "ADMIN").build()
    );
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
      .formLogin(Customizer.withDefaults())
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/deletePatient/**").hasRole("ADMIN")
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .requestMatchers("/user/**").hasRole("USER")
        .anyRequest().authenticated()
      )
      .build();
  }
}
