package com.grocery.exception;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "error")
public class ErrorResponse {

	// General error message about nature of error
	private String type;

	private String message;

	// Specific errors in API request processing
	private List<String> details;
}
