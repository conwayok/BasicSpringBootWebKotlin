package com.conway.basicspringbootwebkotlin.util

import com.conway.basicspringbootwebkotlin.dto.CustomResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity


/** Created by Conway */
class CustomResponseUtil {
  companion object {
    fun <T> ok(payload: T? = null): CustomResponse<T> {
      return CustomResponse(1, "ok", payload)
    }

    fun <T> failed(payload: T? = null): CustomResponse<T> {
      return CustomResponse(-1, "未知的錯誤", payload)
    }

    fun <T> userExistsError(): CustomResponse<T> {
      return CustomResponse(-2, "使用者已存在")
    }

    fun <T> nonExistentUserError(): CustomResponse<T> {
      return CustomResponse(-3, "使用者不存在")
    }

    fun <T> parameterError(): CustomResponse<T> {
      return CustomResponse(-4, "參數錯誤")
    }

    fun <T> nonExistentDataError(): CustomResponse<T> {
      return CustomResponse(-5, "資料不存在")
    }

    fun <T> forbiddenOperationError(): CustomResponse<T> {
      return CustomResponse(-6, "禁止的操作")
    }

    fun <T> wrongDataFormatError(): CustomResponse<T> {
      return CustomResponse(-7, "錯次資料型態")
    }

    fun <T> toResponseEntity(customResponse: CustomResponse<T>): ResponseEntity<CustomResponse<T>> {
      val returnHttpStatus =
        when (customResponse.code) {
          1 -> {
            // ok
            HttpStatus.OK
          }
          -1 -> {
            // general error
            HttpStatus.INTERNAL_SERVER_ERROR
          }
          -2 -> {
            // user exists
            HttpStatus.CONFLICT
          }
          -3 -> {
            // user not found
            HttpStatus.NOT_FOUND
          }
          -4 -> {
            // parameter error
            HttpStatus.FORBIDDEN
          }
          -5 -> {
            // non existent data error
            HttpStatus.NOT_FOUND
          }
          -6 -> {
            // forbidden operation error
            HttpStatus.FORBIDDEN
          }
          -7 -> {
            // wrong data format error
            HttpStatus.BAD_REQUEST
          }
          else -> HttpStatus.INTERNAL_SERVER_ERROR
        }
      return ResponseEntity.status(returnHttpStatus).body(customResponse)
    }
  }
}