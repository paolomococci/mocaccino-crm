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

package local.example.crm.model.controller.rest;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import local.example.crm.model.assembler.CustomerRepresentationModelAssembler;
import local.example.crm.model.entity.CustomerEntity;
import local.example.crm.model.exception.CustomerNotFoundException;
import local.example.crm.model.repository.rest.CustomerRestRepository;

@RepositoryRestController
@RequestMapping(path = "/api/customers")
public class CustomerRestController {

	@Autowired
	CustomerRestRepository customerRestRepository;
	
	@Autowired
	CustomerRepresentationModelAssembler customerRepresentationModelAssembler;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody CustomerEntity customer) 
			throws URISyntaxException {
		EntityModel<CustomerEntity> entityModelOfCustomer;
		entityModelOfCustomer = customerRepresentationModelAssembler
				.toModel(customerRestRepository.save(customer));
		return new ResponseEntity<>(entityModelOfCustomer, HttpStatus.CREATED);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) 
			throws URISyntaxException {
		CustomerEntity customer = customerRestRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(id));
		EntityModel<CustomerEntity> entityModelOfCustomer;
		entityModelOfCustomer = customerRepresentationModelAssembler.toModel(customer);
		return new ResponseEntity<>(entityModelOfCustomer, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> readAll() 
			throws URISyntaxException {
		Iterable<CustomerEntity> customers = customerRestRepository.findAll();
		CollectionModel<EntityModel<CustomerEntity>> collectionModelOfCustomers;
		collectionModelOfCustomers = customerRepresentationModelAssembler
				.toCollectionModel(customers);
		return new ResponseEntity<>(collectionModelOfCustomers, HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> putUpdate(
			@RequestBody CustomerEntity customerUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		 CustomerEntity temporaryEntityOfCustomer = customerRestRepository.findById(id)
				.map(customer -> {
					customer.setName(customerUpdated.getName());
					return customerRestRepository.save(customer);
				}).orElseGet(() -> {
					return customerRestRepository.save(customerUpdated);
				});
		EntityModel<CustomerEntity> entityModelOfCustomer;
		entityModelOfCustomer = customerRepresentationModelAssembler
				.toModel(temporaryEntityOfCustomer);
		return new ResponseEntity<>(entityModelOfCustomer, HttpStatus.OK);
	}
	
	@PatchMapping(path = "/{id}")
	public ResponseEntity<?> patchUpdate(
			@RequestBody CustomerEntity customerUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		CustomerEntity temporaryEntityOfCustomer = customerRestRepository.findById(id)
				.map(customer -> {
					if (customerUpdated.getName() != null) {
						customer.setName(customerUpdated.getName());
					}
					// TODO
					return customerRestRepository.save(customer);
				}).orElseGet(() -> {
					return customerRestRepository.save(customerUpdated);
				});
		EntityModel<CustomerEntity> entityModelOfCustomer;
		entityModelOfCustomer = customerRepresentationModelAssembler
				.toModel(temporaryEntityOfCustomer);
		return new ResponseEntity<>(entityModelOfCustomer, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) 
			throws URISyntaxException {
		customerRestRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
