#language:pt
@BuscaPorMenu
Funcionalidade: Pesquisar produto pelo menu inicial

  Contexto: 
    Dado que o aplicativo esteja aberto
    Quando clicar em algum menu

  @Teste01
  Esquema do Cenario: Pesquisa de produto valido pela lupa
    E clicar em um produto do menu "<laptops>"
    Entao detalhes do produto aparecerao no menu
    

    Exemplos: 
      | speakers                             | tablets                    | laptops                          | mice                          |
      | BOSE SOUNDLINK BLUETOOTH SPEAKER III | HP ELITEPAD 1000 G2 TABLET | HP CHROMEBOOK 14 G1(ENERGY STAR) | HP USB 3 BUTTON OPTICAL MOUSE |

      
     @Teste02
  	Esquema do Cenario: Pesquisa por categoria invalida
    Quando eu clicar em uma categoria
    E filtrar a pesquisa
    Entao nenhum produto será exibido