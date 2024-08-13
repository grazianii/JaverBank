package io.github.grazianii.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        // Log de resposta para depuração
        System.out.println("Error response: " + response);

        switch (response.status()) {
            case 400:
                return new BadRequestException("Bad Request: " + getErrorMessage(response));
            case 401:
                return new UnauthorizedException("Unauthorized: " + getErrorMessage(response));
            case 403:
                return new ForbiddenException("Forbidden: " + getErrorMessage(response));
            case 404:
                return new NotFoundException("Not Found: " + getErrorMessage(response));
            case 500:
                return new InternalServerErrorException("Internal Server Error: " + getErrorMessage(response));
            default:
                return new GeneralFeignException("Feign client error with status " + response.status() + ": " + getErrorMessage(response));
        }
    }

    private String getErrorMessage(Response response) {
        if (response.body() == null) {
            return "No error message available";
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.body().asInputStream()))) {
            StringBuilder errorMessage = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                errorMessage.append(line);
            }
            return errorMessage.toString();
        } catch (IOException e) {
            return "Error reading the response body";
        }
    }

    // Exceções personalizadas para tratamento específico
    public static class BadRequestException extends RuntimeException {
        public BadRequestException(String message) {
            super(message);
        }
    }

    public static class UnauthorizedException extends RuntimeException {
        public UnauthorizedException(String message) {
            super(message);
        }
    }

    public static class ForbiddenException extends RuntimeException {
        public ForbiddenException(String message) {
            super(message);
        }
    }

    public static class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }

    public static class InternalServerErrorException extends RuntimeException {
        public InternalServerErrorException(String message) {
            super(message);
        }
    }

    public static class GeneralFeignException extends RuntimeException {
        public GeneralFeignException(String message) {
            super(message);
        }
    }
}
