### **Java Laboratory - Object-Oriented Programming (OOP)**

**Duration:** 100 minutes (with a break in the middle and after)  
**Tools:** Java (modern version) and IntelliJ Ultimate  
**Project Structure:** Each group will create a **GitHub repository titled "ppLab"**, invite the professor as a member, and organize their work in folders **Lab01, Lab02, ...**. The **Lab01** folder will contain this lab specification.

---

## **Objective**
This lab focuses on reinforcing **Object-Oriented Programming (OOP)** concepts through:
- **Encapsulation, constructors, and method interactions.**
- **Class relationships** through object composition.
- **Code organization** using IntelliJ and GitHub.
- **Automated UML generation** in IntelliJ Ultimate.

---

## **Tasks to be Performed**
Each student will complete **three exercises** that focus on OOP principles. UML diagrams will be **automatically generated** using IntelliJ Ultimate.

### **<span style="color:blue">Exercise 1: "Pessoa" Class (Encapsulation & Constructors)</span>**
1. Create a **Pessoa** class with:
    - Private attributes:
      ```java
      private String nome;
      private char genero;
      private int idade;
      ```
    - Public **getters and setters** for each attribute.
    - **Three constructors**:
      ```java
      public Pessoa() {}
      public Pessoa(String n, char g) { this.nome = n; this.genero = g; }
      public Pessoa(String n, char g, int i) { this(n, g); this.idade = i; }
      ```
    - A method `falar()` that prints a message.

2. Create a **UsaPessoa** class:
    - Instantiate `Pessoa` objects with different constructors.
    - Print their details.
    - Allow the user to **input values** for a new `Pessoa` object via `Scanner`.

---

### **Exercise 2: "Carro" and "Condutor" (Car Race Simulation)**

#### **Objective:**
Create a Java application that simulates a car race between two drivers. This simulation will involve defining `Carro` (Car) and `Condutor` (Driver) classes, and implementing a `Corrida` (Race) class that orchestrates the race with random events affecting each car's performance.


#### **1. Define the `Carro` Class**

- **Private Attributes:**
  ```java
  private String matricula;
  private int velocidadeAtual = 0;
  private final int velocidadeMaxima = 200;
  private boolean ligado;
  private Condutor condutor;
  ```

- **Constructor:**
   - Initialize `matricula` and assign a `Condutor`.
   - Set `ligado` to `false` by default.

  ```java
  public Carro(String matricula, Condutor condutor) {
      this.matricula = matricula;
      this.condutor = condutor;
      this.ligado = false;
  }
  ```

- **Methods:**
  ```java
  public void ligar() {
      ligado = true;
      System.out.println("Carro " + matricula + " ligado: VRUUUUMmmmmmmmmm");
  }

  public void desligar() {
      ligado = false;
      System.out.println("Carro " + matricula + " desligado: MMMmmmmm");
  }

  public void acelerar() {
      if (!ligado) {
          System.out.println("O carro " + matricula + " está desligado! Não pode acelerar.");
          return;
      }
      int aumento = 10 + (int)(condutor.getDestreza() * 0.10);
      velocidadeAtual += aumento;
      if (velocidadeAtual > velocidadeMaxima) {
          velocidadeAtual = velocidadeMaxima;
      }
      System.out.println("Carro " + matricula + " acelerando. Velocidade atual: " + velocidadeAtual + " km/h");
  }

  public void travar(int intensidadeTravagem) {
      if (!ligado) {
          System.out.println("O carro " + matricula + " está desligado! Não pode travar.");
          return;
      }
      velocidadeAtual -= intensidadeTravagem;
      if (velocidadeAtual < 0) {
          velocidadeAtual = 0;
      }
      System.out.println("Carro " + matricula + " travando. Velocidade atual: " + velocidadeAtual + " km/h");
  }
  ```

- **Getters:**
  ```java
  public int getVelocidadeAtual() {
      return velocidadeAtual;
  }

  public Condutor getCondutor() {
      return condutor;
  }

  public boolean isLigado() {
      return ligado;
  }

  public String getMatricula() {
      return matricula;
  }
  ```


#### **2. Define the `Condutor` Class**

- **Private Attributes:**
  ```java
  private String nome;
  private int idade;
  private int destreza;
  ```

- **Constructor:**
  ```java
  public Condutor(String nome, int idade, int destreza) {
      this.nome = nome;
      this.idade = idade;
      this.destreza = destreza;
  }
  ```

- **Public Getters and Setters:**
  ```java
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
  ```


#### **3. Implement the `Corrida` Class**

- **Overview:**
  The `Corrida` class will simulate a race between two `Carro` objects. The race will consist of a predefined number of turns (laps), during which each car will attempt to accelerate and may experience random braking events. At the end of the race, the final speeds of both cars will be compared to determine the winner.

- **Detailed Requirements:**

   1. **Setup:**
      - **Number of Turns:** Define the total number of turns (e.g., 10).
      - **Carros e Condutores:**
         - Create two `Condutor` objects with different attributes.
         - Create two `Carro` objects, each assigned to one of the `Condutor` objects.
      - **Ligar os Carros:**
         - Use the `ligar()` method to turn on both cars before the race begins.

   2. **Race Simulation:**
      - For each turn:
         - **Acionamento de Aceleração:**
            - Each car calls the `acelerar()` method to increase its speed.
         - **Eventos Aleatórios de Travagem:**
            - Introduce a random chance (e.g., 30%) that a car will need to brake due to an obstacle or driver decision.
            - If braking occurs, determine the `intensidadeTravagem` randomly within a specified range (e.g., 5 to 20 km/h).
            - Call the `travar(intensidadeTravagem)` method with the determined intensity.
         - **Limites de Velocidade:**
            - Ensure that `velocidadeAtual` does not exceed `velocidadeMaxima` or drop below 0 after each operation.

   3. **Determining the Winner:**
      - After all turns are completed:
         - Compare the `velocidadeAtual` of both cars.
         - The car with the higher final speed is declared the winner.
         - In case of a tie, declare it as such.

   4. **Desligar os Carros:**
      - Use the `desligar()` method to turn off both cars after the race concludes.

   5. **Output:**
      - Provide clear console outputs indicating each action taken during the race, including accelerations, brakings, and current speeds.
      - Announce the winner at the end of the simulation.

- **Sample Implementation Structure:**
  ```java
  // Corrida.java
  import java.util.Random;

  public class Corrida {
      public static void main(String[] args) {
          // Definir o número de turnos
          final int totalTurnos = 10;

          // Criando condutores
          Condutor condutor1 = new Condutor("Alice", 30, 8);
          Condutor condutor2 = new Condutor("Bob", 28, 7);

          // Criando carros
          Carro carro1 = new Carro("ABC-1234", condutor1);
          Carro carro2 = new Carro("XYZ-5678", condutor2);

          // Ligando os carros
          carro1.ligar();
          carro2.ligar();

          // Inicializando gerador de números aleatórios
          Random random = new Random();

          // Simulando a corrida
          for (int turno = 1; turno <= totalTurnos; turno++) {
              System.out.println("\n-- Turno " + turno + " --");

              // Cada carro tenta acelerar
              carro1.acelerar();
              carro2.acelerar();

              // Determinando se cada carro precisa travar (30% de chance)
              if (random.nextInt(100) < 30) { // 30% de chance
                  int intensidadeTravagem = random.nextInt(16) + 5; // 5 a 20 km/h
                  System.out.println("Carro " + carro1.getMatricula() + " encontrou um obstáculo!");
                  carro1.travar(intensidadeTravagem);
              }

              if (random.nextInt(100) < 30) { // 30% de chance
                  int intensidadeTravagem = random.nextInt(16) + 5; // 5 a 20 km/h
                  System.out.println("Carro " + carro2.getMatricula() + " encontrou um obstáculo!");
                  carro2.travar(intensidadeTravagem);
              }

              // Exibindo velocidades após o turno
              System.out.println("Velocidade após o Turno " + turno + ":");
              System.out.println("Carro " + carro1.getMatricula() + " - " + carro1.getVelocidadeAtual() + " km/h");
              System.out.println("Carro " + carro2.getMatricula() + " - " + carro2.getVelocidadeAtual() + " km/h");
          }

          // Desligando os carros
          carro1.desligar();
          carro2.desligar();

          // Exibindo as velocidades finais
          System.out.println("\nVelocidade final do Carro 1 (" + carro1.getCondutor().getNome() + "): " + carro1.getVelocidadeAtual() + " km/h");
          System.out.println("Velocidade final do Carro 2 (" + carro2.getCondutor().getNome() + "): " + carro2.getVelocidadeAtual() + " km/h");

          // Determinando o vencedor
          if (carro1.getVelocidadeAtual() > carro2.getVelocidadeAtual()) {
              System.out.println("\nVencedor: Carro 1 (" + carro1.getCondutor().getNome() + ")");
          } else if (carro1.getVelocidadeAtual() < carro2.getVelocidadeAtual()) {
              System.out.println("\nVencedor: Carro 2 (" + carro2.getCondutor().getNome() + ")");
          } else {
              System.out.println("\nEmpate na corrida!");
          }
      }
  }
  ```

- **Explanation of the Simulation:**
   - **Turnos (Turns):** The race consists of a fixed number of turns (`totalTurnos`). In each turn, both cars attempt to accelerate.
   - **Eventos Aleatórios (Random Events):** There's a 30% chance in each turn that a car will encounter an obstacle requiring it to brake. The braking intensity is randomly determined between 5 and 20 km/h to simulate varying severities of obstacles.
   - **Velocidade Atual (Current Speed):** After each action, the current speed of each car is updated and displayed. Speed limits are enforced to prevent exceeding the maximum speed or dropping below zero.
   - **Determinação do Vencedor (Determining the Winner):** After all turns, the car with the higher final speed is declared the winner. If both cars have the same speed, the race is declared a tie.


#### **4. Modify the `Carro` Class to Enforce Operational Rules**

Ensure that a **car cannot accelerate or brake unless it is turned on** (`ligado`).

- **Implementation Details:**
   - **Checks in `acelerar()` and `travar()`:**
      - Before performing acceleration or braking, verify the `ligado` status.
      - If the car is not `ligado`, output a message indicating that the action cannot be performed.

- **Example:**
  ```java
  public void acelerar() {
      if (!ligado) {
          System.out.println("O carro " + matricula + " está desligado! Não pode acelerar.");
          return;
      }
      // Restante do código de aceleração...
  }

  public void travar(int intensidadeTravagem) {
      if (!ligado) {
          System.out.println("O carro " + matricula + " está desligado! Não pode travar.");
          return;
      }
      // Restante do código de travagem...
  }
  ```


#### **5. Additional Enhancements and Best Practices**

- **Encapsulation:**
   - All private attributes should be accessed and modified through public getters and setters to maintain data integrity and adhere to object-oriented principles.

- **Input Validation:**
   - Validate inputs where necessary (e.g., ensuring `destreza` is within a reasonable range).

- **Randomness:**
   - Utilize Java's `Random` class to introduce unpredictability in the race, making each simulation unique.

- **User Interaction (Optional):**
   - Enhance the simulation by allowing user inputs to set up driver attributes, number of turns, or even dynamically affect the race based on user decisions.

- **Extensibility:**
   - Design classes in a way that allows easy addition of more cars or different types of events in the race.


#### **6. Expected Output**

When running the `Corrida` class, the console should display a step-by-step account of the race, including:

- Cars being turned on.
- Each turn's actions:
   - Accelerations.
   - Any random braking events.
   - Current speeds after each turn.
- Final speeds of both cars.
- Announcement of the winner or if there's a tie.

**Sample Output:**
```
Carro ABC-1234 ligado: VRUUUUMmmmmmmmmm 
Carro XYZ-5678 ligado: VRUUUUMmmmmmmmmm
-- Turno 1 -- 
Carro ABC-1234 acelerando. Velocidade atual: 18 km/h 
Carro XYZ-5678 acelerando. Velocidade atual: 17 km/h 
Carro ABC-1234 encontrou um obstáculo! 
Carro ABC-1234 travando. Velocidade atual: 10 km/h 
Velocidade após o Turno 1: 
Carro ABC-1234 - 10 km/h 
Carro XYZ-5678 - 17 km/h
-- Turno 2 -- 
Carro ABC-1234 acelerando. Velocidade atual: 28 km/h 
Carro XYZ-5678 acelerando. Velocidade atual: 27 km/h 
Carro XYZ-5678 encontrou um obstáculo! 
Carro XYZ-5678 travando. Velocidade atual: 12 km/h 
Velocidade após o Turno 2: 
Carro ABC-1234 - 28 km/h 
Carro XYZ-5678 - 12 km/h
... (continuação dos turnos)
Carro ABC-1234 desligado: MMMmmmmm 
Carro XYZ-5678 desligado: MMMmmmmm
Velocidade final do Carro 1 (Alice): 86 km/h 
Velocidade final do Carro 2 (Bob): 68 km/h
Vencedor: Carro 1 (Alice)
```
---

### **Exercise 3: "Calculadora" (Basic Calculator)**
1. Define a **Calculadora** class with:
    - Methods for basic operations:
      ```java
      public double soma(double a, double b) { return a + b; }
      public double subtracao(double a, double b) { return a - b; }
      public double multiplicacao(double a, double b) { return a * b; }
      public double divisao(double a, double b) {
          if (b == 0) throw new ArithmeticException("Divisão por zero não permitida.");
          return a / b;
      }
      ```

2. Create a **FazCalculos1** class:
    - Instantiate `Calculadora` and test all operations with **hardcoded values**.

3. Create a **FazCalculos2** class:
    - Allow the user to **input two numbers** via `Scanner` and perform all operations.
    - Print the results.

---

## **GitHub Submission Instructions**
✔ **GitHub Repository Name:** `ppLab`
✔ **Folder Structure:**
```
ppLab/
 ├── Lab01/
 │    ├── lab_specification.md  # This file
 │    ├── UML/                 # Auto-generated UML diagrams
 │    ├── src/                 # Java source code
 │    ├── README.md            # Additional explanations
```
✔ **Commit & Push:** Ensure all code and diagrams are **committed before the end of the lab**.

---

