@Regressivo
Feature: Criar uma simulação

  @ConsultarUsuario
  Scenario: Fazer uma pesquisa com simulação cujo CPF possuia restrição
    When devo consultar uma simulação com restrição via get 97093236014
    Then verificar codigo resposta 200
    And validar mensagem no body O CPF 97093236014 tem problema

  @FluxoExcecao
  Scenario: Fazer uma pesquisa no endpoint dos cenários de restrição cujo CPF NÃO consta nesta
    When devo consultar uma simulação com restrição via get 9709323601445
    Then verificar codigo resposta 204

  @InclusaoDeSimulacaoDeEmprestimo
  Scenario: Efetuar a inclusão de uma simulação no serviço
    When devo incluir uma pessoa via POST
      | nome     | Wesley Rodrigues |
      | cpf      | 85315372073      |
      | email    | teste4@gmail.com |
      | valor    | 15000            |
      | parcelas | 4                |
      | seguro   | false            |
    Then verificar codigo resposta 201
    And validar inclusão da simulação no body 85315372073

  @AlterarDadosDoUsuario
  Scenario: Alterar simulação
    When devo alterar nome do cliente da simulação pelo CPF
      | id       | 11               |
      | nome     | Paulo Soares     |
      | cpf      | 66414919004      |
      | email    | teste4@gmail.com |
      | valor    | 15000            |
      | parcelas | 4                |
      | seguro   | false            |
    And devo verificar se uma alteração foi realizada com sucesso.
    Then verificar codigo resposta 200

  @ConsultarSimulacaoCPF
  Scenario: Consultar uma simulação pelo CPF
    When devo consultar uma simulação via get 17822386034
    Then verificar codigo resposta 200
