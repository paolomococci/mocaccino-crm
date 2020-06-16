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

package local.example.crm.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URISyntaxException;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import local.example.crm.model.controller.rest.ReferentRestController;
import local.example.crm.model.entity.ReferentEntity;

@Component
public class ReferentRepresentationModelAssembler 
		implements RepresentationModelAssembler<ReferentEntity, EntityModel<ReferentEntity>> {

	@Override
	public EntityModel<ReferentEntity> toModel(ReferentEntity referent) {
		try {
			EntityModel<ReferentEntity> entityModelOfReferent = EntityModel.of(referent, 
					linkTo(methodOn(ReferentRestController.class).read(referent.getId())).withSelfRel(), 
					linkTo(methodOn(ReferentRestController.class).readAll()).withRel("referents"));
			return entityModelOfReferent;
		} catch (URISyntaxException uriException) {
			uriException.printStackTrace();
		}
		return EntityModel.of(new ReferentEntity());
	}

	@Override
	public CollectionModel<EntityModel<ReferentEntity>> toCollectionModel(
			Iterable<? extends ReferentEntity> referents) {
		return RepresentationModelAssembler.super.toCollectionModel(referents);
	}
}
