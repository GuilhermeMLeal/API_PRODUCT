package com.br.ecommerce.domain.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProduct(
		String id,
		@NotBlank String name,
		@NotNull BigDecimal price) {

}
