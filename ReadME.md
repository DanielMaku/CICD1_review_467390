# CICD-1 Coding Test — Review, Improve and Reflect

**Student ID: G00467390**  
**Examination group:** A (Room Booking / JPQL)  
**Original examination pull-request URL (`https://github.com/DanielMaku/467390.git`):**  
**New review repository URL:**  

## 1. My original examination self-assessment

Review the code **as submitted in the original examination**. Do not change the original repository, branch or pull request. Check your own Group A or Group B examination paper and award marks only for evidence present in the original submission.

### Task 1 — /40
**My mark: 25 **  
**Evidence from the original code: in the code i had the a relevant idea but didnt have thesame exact headings as the question.**
** i implemented the setters and getters for the details of the room but didnt get the main components needed like attendee count, booking status and associated room**
**i had the back details like room name, room type and the capacities**

### Task 2 — /40
**My mark: 0**  
**Evidence from the original code (files, methods, working or missing requirements):**
**didnt have any relevant implementation for this **


### Task 3 — /20
**My mark: 0**  
**Evidence from the original code:**  
**no attempt made as i didnt get that far into the assesment**

**Total self-assessed original examination mark: 25/100**

**Checkpoint:** Commit this completed self-assessment as the **first review commit in your new repository**, before you modify or add application code. The lecturer decides the official original examination mark.

## 2. Corrections and improvements in my new project

Start from a **fresh copy of the starter template for your own exam group**, in a **new GitHub repository**. You may consult or selectively reuse your own original examination code, but the new project must demonstrate that you understand and can correct it. Do not change your original examination submission.

Describe **two or three important problems** in your original code. For each, explain what was wrong, which class or method you changed in the new project, and why the corrected approach works.

**Problem and correction 1: Only had one dto in my exam instead of 2 different to handle the request and the response.Also didnt have the requirements needed to enter. such as between 2-60, positive ehole numbers and more**  
**also tried to get and set the  room name,type and id in the main exam**
**I corrected this by using 2 seperate dtos for request and response which handles the requirements needed to enter the details. used not null, not blank and others to make sure the requirements are met opposed to when i didnt have anything for teh requirements**

**Problem and correction 2:**  
**Didnt have any exception handlers in my exam**
**added in exceptions for the main global handler,capacity exceeded and not found. this was definely a big part as i didnt have any exception at all in my exam**

**Problem and correction 3 (optional):**  

## 3. API testing and evidence

Use Swagger UI or another HTTP client. For **at least four meaningful checks**, record the request/input, expected result, actual HTTP status/response, and pass/fail. Include unsuccessful cases; a running application alone is not enough.

**Test 1 — successful booking request:**  
- Request / input: exam sheet post request body
- Expected:  201
- Actual HTTP status / body:{
  "id": 1,
  "roomId": 1,
  "roomName": "Lab 201",
  "organiserName": "aoife",
  "attendeeCount": 18,
  "status": "ACTIVE"
  }
- Pass / fail:  pass

**Test 2 — invalid input or excessive attendee count:**  
- Request / input:  
- Expected:  400
- Actual HTTP status / body:{
  "status": 400,
  "error": "Capacity Exceeded",
  "message": "attendeeCount 65 exceeds capacity 10 for room Meeting Room 3"
  }
- Pass / fail: pass 

**Test 3 — missing booking or room:**  
- Request / input:  using id 460
- Expected:  404
- Actual HTTP status / body:  {
  "status": 404,
  "error": "Not Found",
  "message": "Booking not found with id 460"
  }
- Pass / fail:  pass

**Test 4 — requirement specific to my group:**  
- Request / input:  group specific one. group a
- Expected:  200 for all
- Actual HTTP status / body: 200 for all. got an empty bracket for last.
- Pass / fail:  pass

**Group A:** Demonstrate `GET /api/bookings/search?roomName=...` using an exact room name, bookings ordered by attendee count descending, and an empty list for no matches. Add checks if necessary to show all three behaviours.

**Group B:** Run the **provided** Room Service separately on port 8082 and the **new** Booking Service on port 8081. Demonstrate that booking creation obtains room details through OpenFeign and that booking retrieval uses the local Booking database. Do not modify the Room Service.

## 4. Reflection

**What did I understand during the examination but struggle to implement?** 

During the examination I understood what the app was supposed to do but what i struggled to implement was how to make it properly. i only had one DTO, and i didn't have any checks for between 2-60 positive whole numbers no @NotNull or @NotBlank. I also tried to get and set the room name, type and id inside Booking itself instead of linking the Booking to a real Room with @ManyToOne.
I also understood that things could go wrong like a booking might not exist or the room might be too small but I had no exception handlers in my exam. so I didn't know how to turn those problems into a proper 404 or 400 response. Also knew i had to use query but didnt know where to start / i couldnt start  it as i needed the other parts to work before i could do it.

**Which Spring Boot, JPA, validation, JPQL or OpenFeign concept became clearer after correcting my code? Give a specific example.**  
i think validation and dtos became more clear as they couldve been my biggest mistake ib the exam. in the exam I had one that didnt really have anything as useful in it as opposed to now whre i put a min and max value
@Size(min = 2, max = 60, message = "organiserName must be 2-60 characters")
i feel like i understand them but never know when and where to start or place them


**What will I do differently in my next coding test or API development task?**  

next coding test i need to learn which values work woith each other step by step and try to figure out how they work together.
i also need to figure out how the linking works and how i can start certain classes/ finding out which ones i need to do first.

I think the things holding me back in this module is practice which i dont get a lot off because of time. i commute to and from college everyday having to wake up as early as 4:45am and getting home as late as 9pm.
I also have to work on the weekends limiting the time i have to try and attend to all my modules and their assignments as well as the exams which i have to try study for given the limited time i have.
I will try to do better in this module by trying to spend more time practicing for it.

## Review lab assessment — 20 marks

- Honest original self-assessment with code evidence: **4 marks**
- Explanation of mistakes and Spring Boot concepts: **6 marks**
- Corrections in the new application: **4 marks**
- API testing and demonstration of understanding: **4 marks**
- Reflection and future improvement: **2 marks**

**Total: 20 marks.** Simply submitting a working solution does not demonstrate the learning required by this review.

## Proposed mark recovery — only if confirmed for CICD-1

If the same approach as OOP is adopted, the review could recover **up to 30% of marks lost** in the original examination, scaled by the review-lab mark.

**Marks recovered = (100 − official original exam mark) × 0.30 × (review lab mark ÷ 20)**

Example: exam **40/100** and review **16/20** → **14.4 recovered marks**, revised exam **54.4/100**. This is **not an approved CICD-1 policy unless confirmed by the lecturer**. The original official exam mark—not your self-awarded grade—is used in the calculation.

## Submission

Commit and push the **new review repository** with the completed README, corrected Spring Boot code and API-test evidence. Submit its GitHub URL on Moodle. **Do not push any changes to the original examination repository or `exam-work` pull request.**
