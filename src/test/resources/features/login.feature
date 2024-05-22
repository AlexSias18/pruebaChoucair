#language: es
@testfeature
Característica: Añadir productos Exito
  @test1
  Escenario: Añadir productos Exito
    Dado que me encuentro en la página de login de Exito
    Cuando selecciono una categoria y subcategoria
    Y seleccione cinco productos con cantidades aleatorias
    Entonces realizo las validaciones necesarias