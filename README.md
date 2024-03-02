# Веб-приложения "Приют для животных"

## База знаний
- [Требования] ?
- Архитектурное решение (https://docs.google.com/document/d/1t7hEMae2canPNx-rfOA2rVY6c61DaG_X/edit?usp=sharing&ouid=110423896399811611972&rtpof=true&sd=true)
- БД ![image](https://github.com/mrayuu/AnimalShelter/assets/96128195/44e5368d-b1f5-4916-ba69-9ef36993f41e)
- Макет Приложения ![image](https://github.com/mrayuu/AnimalShelter/assets/96128195/8f0f2f1c-440b-4ada-a0f9-eb0d204d441d)



## Структура проекта

Общая структура проекта:

![image](https://github.com/mrayuu/AnimalShelter/assets/96128195/cf9a71e4-4858-4e40-bd9a-46177cf60b28)


Иерхархия backend:

![image](https://github.com/mrayuu/AnimalShelter/assets/96128195/325013d3-baaa-41cb-892d-a15e2b4c7cc3)


Иерархия frontend:

![image](https://github.com/mrayuu/AnimalShelter/assets/96128195/94756397-e53b-47c2-92d6-f9254ec7598d)



## Начало работы

Клонировать репозиторий:

git

git clone https://github.com/mrayuu/AnimalShelter.git

Проект запускается локально


Положение по именам веток разработки:
- master/ - uлавная ветка (Trunk), где хранится стабильная версия продукта.
- feature/ - используются для разработки новых функций. Могут порождаться из ветки master или других feature/ веток.
- bugfix/ - используются для исправления ошибок. Могут порождаться из master.

В своем проекте мы используем методологию Trunk-Based Development, нужную для упрощения процесса разработки. Это связано с тем, что наша команда состоит всего из 3х человек, и с помощью данной методологии мы сможем избежать возможных ошибок.
