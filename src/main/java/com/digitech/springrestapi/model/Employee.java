package com.digitech.springrestapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employee {


   private @Id @GeneratedValue (strategy = GenerationType.AUTO) Long id;
   private String name;
   private String role;

   public Employee() {
   }

   public Employee(String name, String role) {
      this.name = name;
      this.role = role;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Employee employee = (Employee) o;
      return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(role, employee.role);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, name, role);
   }

   @Override
   public String toString() {
      return "Employee{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", role='" + role + '\'' +
              '}';
   }
}
