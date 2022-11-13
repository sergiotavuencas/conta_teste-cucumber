@tag
Feature: Cliente faz saque de dinheiro como um cliente, eu gostaria de sacar em caixa eletrônico, para que eu não tenha que esperar numa fila de banco. 

  @tag1
  Scenario: Cliente especial com saldo negativo
    Given um cliente especial atual com o saldo de -200.0 reais
    When for solicitado um saque no valor de 100.0 reais
    Then deve efetuar o saque e atualizar o saldo da conta para -300.0 reais

  @tag2
  Scenario Outline: Cliente comum com saldo negativo
    Given um cliente comum com saldo atual de 300.0 reais
    When solicitar um saque de 200.0 reais
    Then não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente
