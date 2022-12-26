# JDK 버전 19
# Spring Boot 버전  2.7.0.
# H2-CONSOLE 경로 :  http://localhost:9090/h2-console
# API 가이드 :  http://localhost:9090/swagger-ui/index.html
# 테이블명세서 및 기능목록 문서 위치 (/doc/테이블 명세서 & 기능 목록.xlsx)
# POSTMAN 테스트 용 Json 파일 : Barogo.postman_collection.json

# 배달 조회 api,배송지 변경 api는 로그인 후 token 발급 후 호출이 가능합니다. 
# 호출방법은 Header X-Auth-Token = Bearer  + "accessToken" 입니다.
## 예제)  X-Auth-Token:Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXJvZ29nbzIzIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY3MjA0NjYwNn0.vGw2s854o8n4rQpisIsJfxVWFetcvsQmAww7_Y-VDmJWGB0C0mQBIyHxdYkwreFkqOKkn5J1bo6tVUh1L5R0yw