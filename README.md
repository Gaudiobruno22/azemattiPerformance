
<h1>Azematti Performance</h1>

<h3><strong>Descrição</strong></h3>
<p>Azematti é uma Aplicação Web, para Processamento e Cadastros de Serviços e Usuários, de uma Oficina de Reprogramação E Preparação Automotiva.</p>

<h3>Link da Collection Postman:</h3> 
https://api.postman.com/collections/19755160-4f40a636-d603-48c4-9d68-8b9148a855b0?access_key=PMAT-01HQXP6YG1JYG654G6GFZ43NB0 

<h3><strong>Tecnologias Utilizadas:</strong></h3>

- Java: 11 
- Spring Boot: 2.3.4.RELEASE
- Spring Data JPA
- Flyway Migrations
- Lombok
- Swagger Documentation
- Micro Services
- Open Feign
- Eureka Client
- Zuul Gateway API
- ModelMapper
- Spring Cloud


<h3><strong>Funcionalidades Principais:</strong></h3>

- A aplicação Consiste em um CRUD para Cadastro de Usuários, Seja ele interno ou externo. E automação de Solicitações de Pedidos para pedidos Efetivados.
- Como recurso adicional, a Aplicação tem Integração com uma API pública para Consultar Tabela FIPE de Diversos Modelos.
- Os modelos e Marcas Tem diversas variações de Modelos, e Anos, e Uma Série de parâmetros são passados para ser retornado o Valor da Tabela FIPE.

<h3><strong>Requisitos do Sistema</strong></h3>

- MySQL Connector: 8.0.32 Connector Java
- MySQL Workbench (Manipulação e Verificação dos Dados).
- Java JDK 11 - Open Source
- Database MySQL / SQL.


<h3><strong>Instruções de Uso</strong></h3>

- Necessário uma Instalação do JDK 11 na Máquina, e um banco de Dados (Seja ele MySQL ou SQL), para rodar e testar a aplicação.
- Não é Necessário um Servidor Tomcat configurado, O próprio BootDashBoard (Presente no STS) já carrega o Pool, e Contextos da Aplicação.

<h3><strong>Configuração de Tabelas do Banco de Dados:</strong></h3>

1. As tabelas estão configuradas via Migration Flyway. Então temos os Versionamentos de Scripts que contém os registros necessários para inicializar e poder testar os recursos da aplicação.
2. <strong>Tabelas: > T_USU_SOLCADASTRO > T_CAD_CADASTROS > T_SER_SERVICO > T_SER_TPSERVICO</strong>
3. A tabela de Solicitação de Cadastro (T_USU_SOLCADASTRO), com base em Informações passadas no EndPoint, Efetivam um cadastro na T_CAD_CADASTROS.
4. A Tabela de Serviços (T_SER_SERVICO), exibe as informações dos Serviços Que foram Solicitados para a Empresa, e nela contém informações e valores do Serviço que será Prestado.



<h3><strong>Propriedades da Aplicação:</strong></h3>

1. Todas as Configurações Necessárias para a inicialização estão no application.properties da aplicação.
2. Essa Aplicação Utiliza dois Micro Serviços para serem Hospedadas, que seriam elas um Servidor Eureka (Eureka Client), e outro Micro Serviço para Recepcionar as Portas aleatórias (API Gateway).
3. Nela também é necessário configurar o Usuário e Senha, do Banco de dados que será Hospedada a Aplicação.
4. O Database será Criado Automaticamente, sendo necessário apenas configurar o ambiente e rodar a aplicação, pois as Migrations tomam conta das Inserções e Inserts no Banco.


<h3><strong>Testando a aplicação:</strong></h3>

- É necessário Subir em Ordem as Instâncias: - <strong>AzemattiServer -> AzemattiPerofrmance -> AzemattiGateway</strong>
- Ao subir as Instâncias, é necessário aguardar entre 1 a 2 minutos para ESpearar a Comunicação Entre a APlicação e os Micro Serviços de Gateway, e Servidor Eureka.
1.Os Controllers da Aplicação acima, realizam a chamada das principais atividades da Aaplicação.
2.Os testes são Básicos, com CRUD's para Consulta, e Também EndPoints POST para inserir uma SOlicitação de Cadastro. 
3.Caso a Solicitação deva ser efetivada, a Aplicação também toma conta de Criar automaticamente um Registro de cadastro Efetivado, tornando o cadastro automatizado.

<h3><strong>Contato:</strong></h3>

- Email: brunogmattos22@gmail.com
- LinkedIn: https://www.linkedin.com/in/bruno-gaudio/
- Telefone: +55 (11)99917-1112
