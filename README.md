# Simulador de Investimentos App

Construção de uma app Android desenvolvida em Kotlin que calcula a projeção de investimentos com base em aportes mensais e juros compostos, permitindo ao utilizador configurar o valor inicial, contribuição mensal, taxa de juro anual e o tempo de investimento.

Desafio prático com o objetivo de aplicar **Jetpack Compose**, navegação declarativa com passagem de parâmetros por rotas e gestão de estado reativa com `ViewModel` e `SavedStateHandle`.

---

## Funcionalidades

- ✅ **Splash Screen** - Ecrã inicial de boas-vindas com botão de arranque ("Começar Simulação") para iniciar o fluxo.
- ✅ **Configuração da Simulação** - Ecrã (`SimulationScreen`) para introduzir e validar o Valor Inicial, Aporte Mensal, Taxas de Juro (% ao ano) e o Tempo (anos).
- ✅ **Validação de Dados e Tratamento de Erros** - Controlo de entrada para aceitar apenas valores válidos (com limite de casas decimais e números inteiros para anos), exibindo estados de erro visuais e alertas (`Toast`) caso existam campos por preencher.
- ✅ **Resultados e Resumo Detalhado** - Ecrã de resultados (`ResultsScreen`) com o cálculo automático do Valor final acumulado, Total investido, Lucro obtido e uma tabela detalhada de **Resumo por Ano**.
- ✅ **Navegação com Passagem de Parâmetros** - Transição fluida entre ecrãs utilizando Navigation Compose e passagem de argumentos entre o ecrã de configuração e o de resultados.

---

## Arquitetura

O projeto segue a arquitetura **MVVM (Model-View-ViewModel)** com **Jetpack Compose**, garantindo separação de conceitos e reatividade na UI:

```
✅ UI LAYER (Presentation)
--> Screens (SplashScreen, SimulationScreen, ResultsScreen)
--> Navigation (NavHost + NavController com rotas na sealed class Screen, em Screen.kt)
--> Components & Theme (CustomTextField, CustomButton, Custom Colors, Typography)

✅ STATE & LOGIC LAYER (ViewModel)
--> ViewModel (ResultsViewModel com SavedStateHandle)
--> Single Source of Truth para os cálculos financeiros (Juros Compostos e Aportes Mensais)
```

---

## 🛠️ Tecnologias Utilizadas

### UI & Design
- **Jetpack Compose**: Interface declarativa moderna desenvolvida inteiramente com Composables.
- **Material Design 3**: Componentes modernos como `OutlinedTextField`, `Button`, `Card`, cores e tipografia personalizadas.
- **Custom Components**: Componentes reutilizáveis estilizados (`CustomTextField`, `CustomButton`).

### **Arquitetura & Ciclo de Vida**
- **ViewModel & StateFlow**: Preservação e reatividade dos dados e estados ao longo do fluxo de simulação.
- **SavedStateHandle**: Recuperação segura dos parâmetros passados via rotas de navegação.
- **Navigation Compose**: Gestão declarativa das rotas e transição entre os ecrãs da aplicação.

---

## **Lógica de Cálculo**

O cálculo do valor final acumulado e do resumo anual é realizado no `ResultsViewModel` aplicando a fórmula de **juros compostos com aportes mensais periódicos**, simulando o crescimento ano a ano ao longo do tempo de investimento.

---

## **Build**
- **Gradle**: 8.x / 9.x
- **Kotlin**: 2.2+
- **Android SDK**: 36 / 37 (Compile SDK 37)
- **Min SDK**: 24

### Configuração e Execução do Projeto
1. Efetuar o clone do repositório.
2. Abrir o projeto no Android Studio.
3. Executar a sincronização do Gradle.
4. Compilar e executar a app num dispositivo ou emulador (API 24+).

---

## Autor

**Rui Martins**
- 💻 GitHub: [https://github.com/Rui-Martins23](https://github.com/Rui-Martins23)
- 🔗 LinkedIn: [https://www.linkedin.com/in/rui-pedro-martins-913219169/](https://www.linkedin.com/in/rui-pedro-martins-913219169/)
