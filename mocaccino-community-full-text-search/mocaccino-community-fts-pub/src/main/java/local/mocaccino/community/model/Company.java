/**
 *
 * Copyright 2020 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.mocaccino.community.model;

import local.mocaccino.community.validator.constraint.NameConstraint;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "COMPANY",
        uniqueConstraints = @UniqueConstraint(columnNames = {"NAME"}))
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @NameConstraint
    @Size(min = 8, max = 30)
    @Column(name = "NAME", unique = true, nullable = false, columnDefinition = "VARCHAR(31)")
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setName(String name) {
        this.name = name;
    }
}
