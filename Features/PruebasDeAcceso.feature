Feature: Realizacion de casos ingresando nombre de usuario y contrasena
Scenario: Inicio de sesion con credenciales validas
Given Abrir Chrome
When ingresa Usuario "max" y Password "admin"
Then inicia sesion

Scenario: Inicio de sesion con credenciales invalidas
Given Abrir Chrome
When ingresa Usuario "max" y Password "root"
Then inicia sesion