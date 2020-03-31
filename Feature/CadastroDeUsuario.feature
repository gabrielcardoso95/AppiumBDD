#language:pt
#coding: utf-8
@CadastroDeUsuario
Funcionalidade: Cadastrar Usuario

  Contexto: 
    Dado que o aplicativo esteja aberto
    Quando navegar ate a pagina de cadastro de novo usuario

  @Teste01
  Esquema do Cenário: Cadastro de novo usuario com sucesso
    E Preencher campo de usuario "<Usuario>"
    E Preencher campo de email "<Email>"
    E Preencher campo de senha "<Senha>"
    E Preencher campo de confirmacao de senha "<ConfirmaSenha>"
    E Preencher campo de primeiro nome "<PrimeiroNome>"
    E Preencher campo de sobrenome "<SobreNome>"
    E Preencher campo de telefone "<Telefone>"
    E Selecionar o pais "<Pais>"
    E Preencher campo de estado "<Estado>"
    E Preencher campo de endereco "<Endereco>"
    E Preencher campo de cidade "<Cidade>"
    E Preencher campo de CEP "<CEP>"
    E Pressiona o botao de "Register"
    E Pressionar o botao de menu "<Usuario>"
    Então Usuario aparece logado na tela "<Usuario>"

    Exemplos: 
      | Usuario       | Email           | Senha  | ConfirmaSenha | PrimeiroNome | SobreNome | Telefone    | Pais   | Estado    | Endereco      | Cidade                | CEP      |
      | GabrielBDD337 | gabriel@bdd.com | Aa@123 | Aa@123        | Gabriel      | Cardoso   | 55999911011 | Brazil | São Paulo | Casper Libero | Sao Bernardo do Campo | 09691200 |

  @Teste02
  Esquema do Cenário: Cadastro com senha invalida
    E Preencher o campo de senha com caracteres invalidos "<Senha>"
    Então Sera mostrada mensagem de erro

    Exemplos: 
      | Senha |
      | aa123 |
