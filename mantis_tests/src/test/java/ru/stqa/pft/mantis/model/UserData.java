package ru.stqa.pft.mantis.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "mantis_user_mantis")
public class UserData {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "username")
  private String username;

  @Column(name = "email")
  private String email;

  public UserData withId(int id) {
    this.id = id;
    return this;
  }

  public UserData withUsername(String username) {
    this.username = username;
    return this;
  }

  public UserData withEmail(String email) {
    this.email = email;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserData userData = (UserData) o;
    return Objects.equals(username, userData.username) &&
            Objects.equals(email, userData.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, email);
  }

  @Override
  public String toString() {
    return "UserData{" +
            "username='" + username + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}
