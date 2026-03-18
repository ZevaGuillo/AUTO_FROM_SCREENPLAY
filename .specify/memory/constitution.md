<!--
Sync Impact Report:
- Version change: N/A -> 1.0.0 (initial template population)
- All 5 principle placeholders filled with Screenplay QA-specific content
- Added 2 new sections: Test Architecture Standards, Technology Stack Requirements
- Removed template comments and example placeholders
- Templates verified: spec-template.md (aligned), tasks-template.md (aligned), plan-template.md (aligned)
- No command files to update (none exist)
-->
# Serenity Screenplay QA Automation Constitution

## Core Principles

### I. Business-First Testing
Every test scenario MUST focus on business behavior rather than technical implementation. Tests must validate user journeys from the perspective of business value delivered. Technical details of UI interactions MUST be abstracted into reusable Interactions and Tasks. Tests MUST answer "what business rule is being validated" not "what button is clicked".

### II. Screenplay Pattern Adherence
All automation MUST follow the Screenplay Pattern with clear separation of: Actors (who performs actions), Tasks (business-level activities), Interactions (technical UI actions), and Questions (system state verifications). Actors MUST have specific Abilities (e.g., BrowseTheWeb). Tasks MUST represent business intentions, NOT technical procedures. WebDriver MUST NOT be used directly in Step Definitions.

### III. BDD Declarative Scenarios
Gherkin feature files MUST be declarative, business-focused, and free of technical implementation details. Scenario steps MUST use business language. Given-When-Then structure MUST express business rules. Technical details about locators, waits, or selectors MUST NOT appear in feature files.

### IV. Independent Test Isolation
Each scenario MUST be independently executable without dependencies on other scenarios. Test data MUST be self-contained within each scenario. Shared state between tests MUST be minimized. No scenario can rely on execution order or shared database state that would cause failures when run in isolation.

### V. Single Responsibility in Test Artifacts
Tasks MUST have one business purpose. Interactions MUST perform one technical action. Questions MUST verify one aspect of system state. Step Definitions MUST only delegate to Tasks, never contain business logic. This ensures maximum reusability and maintainability.

## Test Architecture Standards

### Layer Structure
Test code MUST be organized in distinct layers: Abilities (actor capabilities), Tasks (business activities), Interactions (UI operations), Questions (state verification), UI layer (page object locators), StepDefinitions (glue code), and Runners (execution configuration). Each layer MUST import only from layers below it.

### POM vs Screenplay Distinction
POM-based scenarios from the existing framework MUST NOT be migrated or reused in Screenplay implementations. New scenarios MUST demonstrate behavior not already covered. Screenplay MUST leverage Tasks for business flows while POM remains for existing coverage. This ensures clear differentiation and prevents architectural confusion.

## Technology Stack Requirements

### Framework Versions
Serenity-core version MUST be 3.x or compatible. Cucumber version MUST be 7.x or compatible with Serenity. Java version MUST be 11 or higher. Build tool MUST be Gradle with serenity.properties configuration. WebDriver base URL MUST be configurable via serenity.conf.

### Reporting Configuration
Serenity reports MUST capture screenshots only on failure. HTML reports MUST generate after test execution. JSON output MUST be enabled for CI integration. Report location MUST be configurable.

## Governance

All PRs and reviews MUST verify compliance with Screenplay Pattern principles. Any violation of Actor/Task/Interaction separation MUST be rejected. Gherkin scenarios containing technical locators or selectors MUST be refactored before merge. Test architects MUST approve any new Task that combines multiple business activities. Use `.specify/templates/spec-template.md` for defining new test scenarios.

**Version**: 1.0.0 | **Ratified**: 2026-03-18 | **Last Amended**: 2026-03-18