Feature: Registro de agenda con datos prestablecidos 
Scenario: Creacion de nuevo registro en la agenda
Given Abrir Navegador Chrome
When ingresar Usuario "max" y Password "admin"
And iniciar sesion
And hace click en Nuevo Agendamiento
Then ingresa los datos para el agendamiento idmascota "1" rutDueno "17229147-3" nombreMascota "Floki" fecha y hora "2021/09/23 15:00"
And crea nuevo agendamiento