# Implementation Plan - ResultsScreen Top App Bar

Implement the top app bar for `ResultsScreen` matching the provided UI design, featuring a back navigation arrow and the title "Resultado da Simulação" with its icon badge.

## User Review Required

> [!NOTE]
> We will use Material 3's `TopAppBar` (or `CenterAlignedTopAppBar`) combined with custom row content to match the exact design (back arrow + icon badge + title text).

## Proposed Changes

### [Presentation Layer]

#### [MODIFY] [ResultsScreen.kt](file:///C:/Users/rui-m/AndroidStudioProjects/SimuladorInvestimentosChallenge/app/src/main/java/com/example/simuladorinvestimentoschallenge/presentation/ResultsScreen.kt)
- Implement `ResultsScreen` Composable with a Scaffold layout.
- Add a custom or Material 3 `TopAppBar` containing:
  - Back navigation `IconButton` with an arrow icon.
  - Title section with a green rounded square icon (chart/graph icon) and the text "Resultado da Simulação".
- Add a preview function `@Preview` for `ResultsScreen`.

## Verification Plan

### Automated Tests
- Build the project using gradle build or verify preview rendering.

### Manual Verification
- View the Compose Preview of `ResultsScreen` in Android Studio to confirm layout alignment, colors, and iconography.
