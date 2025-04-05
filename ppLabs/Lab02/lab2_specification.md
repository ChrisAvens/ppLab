# Laboratório 02 de Programação Orientada a Objetos em Java

## **Objetivos**
## **Parte 1: Herança e Polimorfismo**
## **Parte 2: Interfaces e Classes Abstratas**

## **Pré-requisitos**
- Conhecimento básico de programação em Java.
- Entendimento dos conceitos de **classes**, **objetos**, **herança** e **polimorfismo**.
- Familiaridade com o ambiente de desenvolvimento **IntelliJ IDEA**.

## **Configuração do Ambiente**
1. **Instalação do IntelliJ IDEA**: Assegure-se de que o IntelliJ IDEA está instalado na sua máquina. 

2. **Configuração do Projeto**:
    - Abra o IntelliJ IDEA.
    - Crie um novo projeto Java.
    - Organize o projeto com os seguintes pacotes:
        - `Lab01.Ex02`
        - `Lab02.Ex01`

## **Código Fornecido**
Você receberá o código do pacote `Lab01.Ex02`, que inclui as classes `Carro` e `Condutor`. Esse código servirá como base para as atividades no pacote `Lab02.Ex01`.

### **1. Classe `Carro` em `Lab01.Ex02`**
```java
package Lab01.Ex02;

public class Carro {
    private final String matricula;
    private int velocidadeAtual;
    private final int velocidadeMaxima = 200;
    private boolean ligado;
    private final Condutor conductor;

    public Carro(String matricula, Condutor conductor) {
        this.matricula = matricula;
        this.conductor = conductor;
        this.ligado = false;
        this.velocidadeAtual = 0;
    }

    public void ligar() {
        ligado = true;
        System.out.println("Carro " + matricula + " ligado.");
    }

    public void desligar() {
        ligado = false;
        System.out.println("Carro " + matricula + " desligado.");
    }

    public void acelerar() {
        if (!ligado) {
            System.out.println("O carro está desligado! Não pode acelerar.");
            return;
        }
        velocidadeAtual += 10;
        if (velocidadeAtual > velocidadeMaxima)
            velocidadeAtual = velocidadeMaxima;
        System.out.println("Velocidade atual: " + velocidadeAtual + " km/h");
    }

    public void travar(int intensidade) {
        if (!ligado) {
            System.out.println("O carro está desligado! Não pode travar.");
            return;
        }
        velocidadeAtual -= intensidade;
        if (velocidadeAtual < 0)
            velocidadeAtual = 0;
        System.out.println("Velocidade atual: " + velocidadeAtual + " km/h");
    }

    public void buzinar() {
        System.out.println("Buzina padrão do carro.");
    }
}
```

### **2. Classe `Condutor` em `Lab01.Ex02`**
```java
package Lab01.Ex02;

public class Condutor {
    private String nome;
    private int idade;
    private int destreza;

    public Condutor(String nome, int idade, int destreza) {
        this.nome = nome;
        this.idade = idade;
        this.destreza = destreza;
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    @Override
    public String toString() {
        return "Conductor{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", destreza=" + destreza +
                '}';
    }
}
```

## **Atividades no Pacote `Lab02.Ex01`**
As tarefas a seguir devem ser realizadas no pacote `Lab02.Ex01`. Utilize o IntelliJ IDEA para criar as classes e implementar os requisitos conforme descrito.

### **1. Criação das Subclasses `Citadino` e `Van`**

#### **a. Classe `Citadino`**
- **Extensão**: Estender a classe `Carro`.
- **Métodos Específicos**:
    - Implementar o método `ligarACManual()` que imprime "AC ligado!".
- **Sobrescrita de Métodos**:
    - Sobrescrever o método `buzinar()` para exibir "Buzina do Citadino: Piii Piii!".

#### **b. Classe `Van`**
- **Extensão**: Estender a classe `Carro`.
- **Métodos Específicos**:
    - Implementar o método `desligarAirbagPassageiro()` que imprime "Airbag desligado!".
- **Sobrescrita de Métodos**:
    - Sobrescrever o método `buzinar()` para exibir "Buzina do Van: Bip Bip".


### **3. Classe de Teste `TestEx01`**
Crie uma classe `TestEx01` dentro do pacote `Lab02.Ex01` que realiza as seguintes ações:

- **Criação de Objetos**:
    - Instanciar objetos de `Citadino` e `Van` com diferentes matrículas.
    - Criar uma lista de `Carro` que contenha instâncias de ambas as subclasses.

- **Interações com os Objetos**:
    - Iterar sobre a lista de carros e para cada carro:
        - Chamar os métodos `ligar()`, `acelerar()`, `buzinar()`, e `desligar()`.
        - Utilizar o operador `instanceof` para verificar o tipo do carro e chamar métodos específicos:
            - Se for uma instância de `Citadino`, chamar `ligarACManual()`.
            - Se for uma instância de `Van`, chamar `desligarAirbagPassageiro()`.

### **4. Executando o Programa**
Após a implementação, execute a classe `TestEx01` para observar o comportamento dos diferentes tipos de carros e verificar o funcionamento da herança e do polimorfismo.
Exemplo de resultados apresentados pela execução do programa.
```
Carro AAA-1111 ligado.
Velocidade atual: 10 km/h
Buzina do Citadino: Piii Piii!
---- Using the element of the list as Citadino ----
AC ligado!
Carro AAA-1111 desligado.
---------------------------------------
Carro BBB-2222 ligado.
Velocidade atual: 10 km/h
Buzina do Van: Bip Bip
---- Using the element of the list as Van ----
Airbag desligado!
Carro BBB-2222 desligado.
---------------------------------------
Carro CCC-3333 ligado.
Velocidade atual: 10 km/h
Buzina do Citadino: Piii Piii!
---- Using the element of the list as Citadino ----
AC ligado!
Carro CCC-3333 desligado.
---------------------------------------
Carro DDD-4444 ligado.
Velocidade atual: 10 km/h
Buzina do Van: Bip Bip
---- Using the element of the list as Van ----
Airbag desligado!
Carro DDD-4444 desligado.
---------------------------------------

Process finished with exit code 0
```

## **Considerações Finais**
Este laboratório visa fortalecer o entendimento de conceitos fundamentais da programação orientada a objetos em Java. 

Ao implementar herança e polimorfismo, você estará preparado para desenvolver aplicações mais complexas e robustas.

Caso tenha dúvidas ou precise de assistência adicional, não hesite em buscar ajuda.

---
## **Parte 2: Interfaces e Classes Abstratas**

### **Objetivo**
Nesta segunda parte do laboratório, os estudantes irão aprofundar os conceitos de **interfaces** e **classes abstratas** em Java. Utilizando o código fornecido na Parte 1, vocês irão estender as funcionalidades das classes existentes, implementando interfaces e criando hierarquias de classes mais flexíveis e reutilizáveis.

### **Pré-requisitos**
- Completar as atividades da **Parte 1**.
- Compreensão dos conceitos de **interfaces** e **classes abstratas** em Java.
- Familiaridade com o ambiente de desenvolvimento **IntelliJ IDEA**.

### **Configuração do Ambiente**
Certifique-se de que o projeto Java do laboratório está aberto no **IntelliJ IDEA** e que os pacotes `Lab01.Ex02` e `Lab02.Ex01` estão devidamente organizados conforme descrito na Parte 1.

### **Atividades no Pacote `Lab02.Ex02`**
As tarefas a seguir devem ser realizadas no pacote `Lab02.Ex02`. Utilize o **IntelliJ IDEA** para criar as classes e implementar os requisitos conforme descrito.

#### **1. Transformar a Classe `Carro` em Abstrata**
- **Objetivo**: Modificar a classe `Carro` existente no pacote `Lab01.Ex02` para torná-la abstrata e permitir a criação de subclasses com comportamentos específicos.

- **Passos**:
    1. **Criar uma Nova Classe Abstrata `CarroAbstrato`**:
        - No pacote `Lab02.Ex02`, crie uma nova classe chamada `CarroAbstrato` que estende `Lab01.Ex02.Carro`.
        - Marque a classe `CarroAbstrato` como `abstract`.

    2. **Adicionar um Método Abstrato `buzinar()`**:
        - Dentro de `CarroAbstrato`, declare um método abstrato `buzinar()` sem implementação.

 
#### **2. Definição da Interface `Buzina`**
- **Objetivo**: Criar uma interface que define o comportamento de buzinar, permitindo diferentes implementações em subclasses distintas.

- **Passos**:
    1. **Criar a Interface `Buzina`**:
        - No pacote `Lab02.Ex02`, crie uma interface chamada `Buzina`.
        - Defina o método `void buzinar();` dentro da interface.

    2. **Implementar a Interface nas Subclasses**:
        - As subclasses que representarem tipos específicos de carros deverão implementar a interface `Buzina` e fornecer a implementação do método `buzinar()` de acordo com o comportamento desejado.

#### **3. Implementação da Classe Concreta `CarroReal`**
- **Objetivo**: Criar uma classe concreta que representa um tipo específico de carro, implementando os comportamentos definidos pela interface `Buzina`.

- **Passos**:
    1. **Criar a Classe `CarroReal`**:
        - No pacote `Lab02.Ex02`, crie uma nova classe chamada `CarroReal` que estende `CarroAbstrato` e implementa a interface `Buzina`.

    2. **Implementar o Método `buzinar()`**:
        - Dentro de `CarroReal`, forneça uma implementação concreta para o método `buzinar()`, por exemplo:
          ```java
          @Override
          public void buzinar() {
              System.out.println("Buzina do CarroReal: Toooooooot!");
          }
          ```

    3. **Adicionar Construtor**:
        - Implemente um construtor que chame o construtor da superclasse `CarroAbstrato`, recebendo os parâmetros necessários (por exemplo, `matricula` e `condutor`).

#### **4. Criação da Classe de Teste `TestEx02`**
- **Objetivo**: Implementar uma classe de teste para verificar o funcionamento das classes abstrações e interfaces criadas.

- **Passos**:
    1. **Criar a Classe `TestEx02`**:
        - No pacote `Lab02.Ex02`, crie uma nova classe chamada `TestEx02` contendo o método `main`.

    2. **Implementar o Método `main`**:
        - No método `main`, realize as seguintes ações:
            1. **Instanciar um Objeto `Condutor`**:
                - Nome: "Bob"
                - Idade: 35
                - Destreza: 7
            2. **Criar um Objeto `CarroReal`**:
                - Matrícula: "DDD-4444"
                - Condutor: Objeto criado anteriormente.
            3. **Interações com o Objeto `CarroReal`**:
                - Chamar os métodos `ligar()`, `acelerar()`, `buzinar()`, `travar(15)`, e `desligar()`.
            4. **Executar o Programa**:
                - Executar o método `main` e verificar se as saídas são as esperadas.


#### **5. Executando e Testando o Programa**
- **Objetivo**: Verificar se as implementações estão corretas e se os comportamentos definidos estão funcionando conforme o esperado.

- **Passos**:
    1. **Executar a Classe `TestEx02`**:
        - No **IntelliJ IDEA**, abra a classe `TestEx02`.
        - Clique com o botão direito no editor de código e selecione **Run 'TestEx02.main()'**.

    2. **Verificar as Saídas no Console**:
        - Confirme se as mensagens impressas correspondem às ações realizadas, por exemplo:
          ```
          Carro DDD-4444 ligado.
          Velocidade atual: 10 km/h
          Buzina do CarroReal: Toooooooot!
          Velocidade atual: 0 km/h
          Carro DDD-4444 desligado.
          ```


### **Considerações Finais**
Esta segunda parte do laboratório visa consolidar o entendimento sobre **interfaces** e **classes abstratas** em Java, mostrando como essas ferramentas podem ser utilizadas para criar hierarquias de classes mais flexíveis e bem estruturadas. Ao implementar essas soluções, vocês estarão preparados para desenvolver aplicações mais complexas e robustas, aproveitando os benefícios da programação orientada a objetos.

**Dicas:**
- **Reutilização de Código**: Utilize os métodos já implementados na classe `Carro` para evitar redundância.
- **Sobrescrita de Métodos**: Utilize a anotação `@Override` ao implementar métodos provenientes de interfaces ou ao sobrescrever métodos da superclasse.
- **Organização do Código**: Mantenha seu código organizado e bem comentado para facilitar a leitura e manutenção.
- **Testes Frequentes**: Teste suas classes frequentemente para garantir que cada componente funciona corretamente antes de prosseguir.

Caso tenha dúvidas ou precise de assistência adicional, não hesite em buscar ajuda do instrutor ou dos colegas de classe.

---


**Boa programação! 🚗💨🔧**