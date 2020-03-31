#language:pt
@BuscaPorLupa
Funcionalidade: Pesquisar produto pela lupa

  Contexto: 
    Dado que o aplicativo esteja aberto
    Quando pressionar o botao da lupa

  @Teste01
  Esquema do Cenario: Pesquisa de produto valido pela lupa
    E preencher a barra de pesquisa com produto valido "<speakers>"
    E pressionar novamente o botao da lupa
    E clicar em um produto da lista "<speakers>"
    Entao detalhes do produto aparecerao na tela

    Exemplos: 
      | speakers                             | tablets                    | laptops                          | mice                          |
      | BOSE SOUNDLINK BLUETOOTH SPEAKER III | HP ELITEPAD 1000 G2 TABLET | HP CHROMEBOOK 14 G1(ENERGY STAR) | HP USB 3 BUTTON OPTICAL MOUSE |

  @Teste02
  Esquema do Cenário: Pesquisa de produto invalido pela lupa
    E preencher a barra de pesquisa com produto invalido "<invalido>"
    E pressionar novamente o botao da lupa
    Entao aparecera a mensagem "No results for"

    Exemplos: 
      | invalido |
      | Ferrari  |
