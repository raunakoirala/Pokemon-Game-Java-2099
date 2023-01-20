# FIT2099 Assignment (Semester 2 - 2022) - Pokemon!

## CL_Lab7Group5
Team members:
Raunak Koirala
*
*

Link to contribution logs spreadsheet: https://docs.google.com/spreadsheets/d/1z3_UeP_lR0X4kZdN-PbN7SxJbu9lY6RN7ykJtKTF9Rw/edit?usp=sharing

## New assignment 3 UML and Rationales in Assignment 3 pdf in docs, the designs have been added to another document under Assignment 2 pdf for easier readability.

Link: https://git.infotech.monash.edu/fit2099/fit2099-s2-2022/fit2099-s2-2022-assignments/CL_Lab7Group5/project/-/blob/main/docs/FIT2099_Assignment3_CL_Lab7Group5.pdf




# Assignment 3 Creative Mode Tables:

# Requirement 4

**Title**: 
Electric Pikachu

**Description**:
This new feature adds a new pokemon, Pikachu. There is also a new element created, Electric, for this new pokemon. This new pokemon has a vicious attack that uses thunder to inflict a large amount of damage on other pokemon however this has a small chance of occuring. The pokemon isn't affected by the sunlight and yet heals during the night. The pokemon cannot be captured but instead has to be bought from the NurseJoy trader and can still be summoned and fed. The Pikachu also has a backup weapon that uses the special attack lightning simiar to the other pokemon. 

**Explanation why it adheres to SOLID principles** (WHY):

- The pokemon adheres to the Single Responsibility Principle as we implement different classes to carry out their own functionalities similar to the other Pokemons before.  By making our class easily extendable and through the use of abstraction from the main pokemon class, we ensure that we satisfy the open-closed principle and the Liskov Substitution principle. This feature meets the dependency inversion principle through being an extension of an abstract class (Pokemon), and as such the high level module does not depend on the lower one.

| Requirements                                                                                                            | Features (HOW) / Your Approach /Answer
| ----------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Must use at least two (2) classes from the engine package                                                              | We use three classes from the engine package: Actor, Action, and Item. Pikachu extends Actor, Summmon and Buy extend Action, BackupWeapon extends Item |
| Must use/re-use at least one(1) existing feature (either from assignment 2 and/or fixed requirements from assignment 3)                                                                                                                                                       |We reuse the buying action, summoning action, attacking actions, day/night effects and nursejoy in our implementation
| Must use existing or create new abstractions (e.g., abstract or interface, apart from the engine code)                                                                                                                                                                    |Uses pokemon absract base, time perception interface and behaviour interface
| Must use existing or create new capabilities                                                                                                                                                                                                                                  |New capability for new element and reuses all other capabilities for Pokemon from Assingment 2

---

# Requirement 5


**Title**: 
Optimised healer and trader, NurseJoy

**Description**:
This new feature updates the NurseJoy NPC within the program. The player can now request NurseJoy to heal all their Pokemon when they visit the center. The NurseJoy now also sells new pokeballs with the other pokemon including the new Pikachu pokemon added earlier, and also sells the Elecric pokefruit to feed to the Pikachu. 

**Explanation why it adheres to SOLID principles** (WHY):

- We inherit the Actor class from the engine and use NurseJoy as an extension of it thus ensuring the that the class is responsible for less functionality leading to fewer dependencies to other classes. This meets the Single REsponsibility principle and leads to better code organization. We can always overwrite and extend the behaviours within this class while keeping it closed for modification adhering to the Open Closed Principle. As it inherits from Actor it is completely substitutable for the base class and avoids misusing inhertiance, thus meeting the Liskov Substitution principle. We don't implement unnecessary methods or functions and ensure that higher level modules don't rely on lower level ones thus satisfying the Interface Segregation Principle and the Dependency Inversion Principle, respectfully.

| Requirements                                                                                                            | Features (HOW) / Your Approach /Answer
| ----------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Must use at least two (2) classes from the engine package                                                               | We use three classes from the engine package: Actor, Item, and Action. HealPokemon extends Action, NurseJoy extends Actor, Pokeball and Pokefruit extends Item |
| Must use/re-use at least one(1) existing feature (either from assignment 2 and/or fixed requirements from assignment 3)                                                                                                                                                                        |We reuse the NurseJoy and buying action from the previous assignments
| Must use existing or create new abstractions (e.g., abstract or interface, apart from the engine code)                                                                                                                                                                                         |Uses behaviour interface
| Must use existing or create new capabilities                                                                                                                                                                                                                                                   |Uses Status capability and element as an capability.




