# CS 491 Project


# Software Requirements Specification
## Yahtzee Game
Prepared by Jonathon Byers and Stephen Slas
CS491
10/9/2022

Table of Contents
=================
  * [Revision History](#revision-history)
  * [Introduction](#1-introduction)
    * 1.1 [Purpose](#11-purpose)
    * 1.2 [Document Conventions](#12-document-conventions)
    * 1.3 [Intended Audience and Reading Suggestions](#13-intended-audience-and-reading-suggestions)
    * 1.4 [Product Scope](#14-product-scope)
    * 1.5 [References](#15-references)
  * [Overall Description](#overall-description)
    * 2.1 [Product Perspective](#21-product-perspective)
    * 2.2 [Product Functions](#22-product-functions)
    * 2.3 [User Classes and Characteristics](#23-user-classes-and-characteristics)
    * 2.4 [Operating Environment](#24-operating-environment)
    * 2.5 [Design and Implementation Constraints](#25-design-and-implementation-constraints)
    * 2.6 [User Documentation](#26-user-documentation)
    * 2.7 [Assumptions and Dependencies](#27-assumptions-and-dependencies)
  * [External Interface Requirements](#external-interface-requirements)
    * 3.1 [User Interfaces](#31-user-interfaces)
    * 3.2 [Hardware Interfaces](#32-hardware-interfaces)
    * 3.3 [Software Interfaces](#33-software-interfaces)
    * 3.4 [Communications Interfaces](#34-communications-interfaces)
  * [System Features](#system-features)
    * 4.1 [System Feature 1](#41-system-feature-1)
    * 4.2 [System Feature 2 (and so on)](#42-system-feature-2-and-so-on)
  * [Other Nonfunctional Requirements](#other-nonfunctional-requirements)
    * 5.1 [Performance Requirements](#51-performance-requirements)
    * 5.2 [Safety Requirements](#52-safety-requirements)
    * 5.3 [Security Requirements](#53-security-requirements)
    * 5.4 [Software Quality Attributes](#54-software-quality-attributes)
    * 5.5 [Business Rules](#55-business-rules)
  * [Other Requirements](#other-requirements)
* [Appendix A: Glossary](#appendix-a-glossary)
* [Appendix B: Analysis Models](#appendix-b-analysis-models)
* [Appendix C: To Be Determined List](#appendix-c-to-be-determined-list)




## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
|      |         |                     |           |
|      |         |                     |           |
|      |         |                     |           |

## 1. Introduction
### 1.1 Purpose 
This is our version of the dice rolling game Yahtzee, otherwise known as Yacht Dice. This is a game that is played by rolling a hand of 5 dice in order to fill out a scorecard. The player with the highest score when all scorecards are filled out wins. This document intends to cover the full scope of the game from its backend to its user interface.

### 1.2 Document Conventions
No document conventions currently.

### 1.3 Intended Audience and Reading Suggestions
This document is intended for the professor of the class, other classmates, and any unaffiliated people that the game may be shared to. The document is structured with this introduction followed by a description of the application, individual system features, information on the interfaces, and ends with other miscellanious information.

The professor should read this document in order from overview to each following section in order to see the full scope of the document.

Other classmates should read the introduction and then decide what information is pertinent to them. If they intend to play the game they should look at the system features. If they wish to learn how it was made, they should read the description and then use the table of contents for whichever specific information they need to know.

Anyone other users should read the introduction. Another section of note would be 2.2 Product Features.
### 1.4 Product Scope
This game is intended for 1-4 players. The user should be able to pick the number of players before the game starts. When the game starts it will show the current player's scorecard and a play field for rolling the dice. The application will implement the full play loop of rolling hands and recording scores. After each turn it should pass to the next player. When each player fully fills out their scorecard, the game will tally the scorecards and determine a winner. The game will then be able to be restarted.

### 1.5 References
https://github.com/Pencilburner/CS491Project.git
![Use Case Diagram](UseCaseDiagram.png)
![Activity Diagram](ActivityDiagram.png)
![Sequence Diagram](SequenceDiagram.png)

## Overall Description
### 2.1 Product Perspective
This is a new, self-contained product. The SRS will cover the entirety of the system and all of its functionality. It will be made from the ground up with no sections originating from outside sources.
### 2.2 Product Functions
When the application is launched, the user will be see a main menu. On this initial menu the following functionalities are planned:
* Set Number of Players
* Rules/How to Play (optional)
* Set Names of Players (optional)
* See previous scores (optional)
* Start Game

Once the game is launched there will be a separate game interface. This interface will be split between the scorecard and the dice rolling sections. The score card should allow:
* See active players scorecard
* See see active players total score
* Have a dropdown menue to switch to different players' scorecards (optional)
* Click on a field to submit current hand to that field

The dice rolling area will allow:
* Rolling a hand of 5 dice
* Choosing a number of dice to keep
* Rerolling any dice not kept 
* Repeat choosing and rerolling sequence up to one more time
* Submitting final hand

Once a player has submitted a hand into a score field, the game will repeat this process on the next player. When every player has a filled out scorecard, the game will end. The player with the highest overall score will be declared the winner. The user will then be offered to start the game again or return to the main menu.

### 2.3 User Classes and Characteristics
Currently planned classes are:
* Main Class
     This will be the main class to launch the UIs from.
* Main Menu UI Class 
     This will be the first menu the user sees and will handle user inputs on this UI
* Game UI Class
     This will be the game UI described above and will handle all actions involved in playing the game
Possible classes are:
* Useful functions class
    Individual methods can be placed her for better organization

### 2.4 Operating Environment
This application will be implemented on java and will be playable on any computer with java installed.
### 2.5 Design and Implementation Constraints
The two largest constraints will be time and ability. The project will have regular deadlines that we must reach throughout the semester. The final product must be complete by the end of the semester. In addition, dedicating the time requried for this project will be a challenge while keeping up with other classes and part-time jobs. Proper time management will be critical to success.

Addtionally both developers are novices with regards to software engineering and development. Many planned aspects of this project will be entirely new to us and will require much trial and error to get workable. Accounting for our own inabilities will be necessary to success.
### 2.6 User Documentation
This SRS and a README will be included.
### 2.7 Assumptions and Dependencies
No assumptions or dependencies at this time.
## External Interface Requirements
### 3.1 User Interfaces
Describe the logical characteristics of each interface between the software product and the users. This may include sample screen images, any GUI standards or product family style guides that are to be followed, screen layout constraints, standard buttons and functions (e.g., help) that will appear on every screen, keyboard shortcuts, error message display standards, and so on. Define the software components for which a user interface is needed. Details of the user interface design should be documented in a separate user interface specification.
### 3.2 Hardware Interfaces
Describe the logical and physical characteristics of each interface between the software product and the hardware components of the system. This may include the supported device types, the nature of the data and control interactions between the software and the hardware, and communication protocols to be used.
### 3.3 Software Interfaces
Describe the connections between this product and other specific software components (name and version), including databases, operating systems, tools, libraries, and integrated commercial components. Identify the data items or messages coming into the system and going out and describe the purpose of each. Describe the services needed and the nature of communications. Refer to documents that describe detailed application programming interface protocols. Identify data that will be shared across software components. If the data sharing mechanism must be implemented in a specific way (for example, use of a global data area in a multitasking operating system), specify this as an implementation constraint.
### 3.4 Communications Interfaces
Describe the requirements associated with any communications functions required by this product, including e-mail, web browser, network server communications protocols, electronic forms, and so on. Define any pertinent message formatting. Identify any communication standards that will be used, such as FTP or HTTP. Specify any communication security or encryption issues, data transfer rates, and synchronization mechanisms.
## System Features
This template illustrates organizing the functional requirements for the product by system features, the major services provided by the product. You may prefer to organize this section by use case, mode of operation, user class, object class, functional hierarchy, or combinations of these, whatever makes the most logical sense for your product.
### 4.1 System Feature 1
Don’t really say “System Feature 1.” State the feature name in just a few words.
4.1.1   Description and Priority
 Provide a short description of the feature and indicate whether it is of High, Medium, or Low priority. You could also include specific priority component ratings, such as benefit, penalty, cost, and risk (each rated on a relative scale from a low of 1 to a high of 9).
4.1.2   Stimulus/Response Sequences
 List the sequences of user actions and system responses that stimulate the behavior defined for this feature. These will correspond to the dialog elements associated with use cases.
4.1.3   Functional Requirements
 Itemize the detailed functional requirements associated with this feature. These are the software capabilities that must be present in order for the user to carry out the services provided by the feature, or to execute the use case. Include how the product should respond to anticipated error conditions or invalid inputs. Requirements should be concise, complete, unambiguous, verifiable, and necessary. Use “TBD” as a placeholder to indicate when necessary information is not yet available.
 
 Each requirement should be uniquely identified with a sequence number or a meaningful tag of some kind.

### 4.2 System Feature 2 (and so on)

## Other Nonfunctional Requirements
### 5.1 Performance Requirements
If there are performance requirements for the product under various circumstances, state them here and explain their rationale, to help the developers understand the intent and make suitable design choices. Specify the timing relationships for real time systems. Make such requirements as specific as possible. You may need to state performance requirements for individual functional requirements or features.
### 5.2 Safety Requirements
Specify those requirements that are concerned with possible loss, damage, or harm that could result from the use of the product. Define any safeguards or actions that must be taken, as well as actions that must be prevented. Refer to any external policies or regulations that state safety issues that affect the product’s design or use. Define any safety certifications that must be satisfied.
### 5.3 Security Requirements
Specify any requirements regarding security or privacy issues surrounding use of the product or protection of the data used or created by the product. Define any user identity authentication requirements. Refer to any external policies or regulations containing security issues that affect the product. Define any security or privacy certifications that must be satisfied.
### 5.4 Software Quality Attributes
Specify any additional quality characteristics for the product that will be important to either the customers or the developers. Some to consider are: adaptability, availability, correctness, flexibility, interoperability, maintainability, portability, reliability, reusability, robustness, testability, and usability. Write these to be specific, quantitative, and verifiable when possible. At the least, clarify the relative preferences for various attributes, such as ease of use over ease of learning.
### 5.5 Business Rules
List any operating principles about the product, such as which individuals or roles can perform which functions under specific circumstances. These are not functional requirements in themselves, but they may imply certain functional requirements to enforce the rules.

## Other Requirements
Define any other requirements not covered elsewhere in the SRS. This might include database requirements, internationalization requirements, legal requirements, reuse objectives for the project, and so on. Add any new sections that are pertinent to the project.
### Appendix A: Glossary
Define all the terms necessary to properly interpret the SRS, including acronyms and abbreviations. You may wish to build a separate glossary that spans multiple projects or the entire organization, and just include terms specific to a single project in each SRS.
### Appendix B: Analysis Models
Optionally, include any pertinent analysis models, such as data flow diagrams, class diagrams, state-transition diagrams, or entity-relationship diagrams.
### Appendix C: To Be Determined List
Collect a numbered list of the TBD (to be determined) references that remain in the SRS so they can be tracked to closure.
