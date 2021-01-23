# Composite Behaviour Exercise
### Composition over Inheritance
The initial code contains one bouncing ball vertically and other shrinking and expanding in size.
<br>
These two balls are implemented in ```BouncingBall.java``` and ```ElasticBall.java```.
<br>
**Requirement** - Create a ball which has both the functionalities i.e. bounces and resizes at the same time.
<br>
**Solution1:**
- We wanted to use the behaviour of both the balls in BouncingElasticBall but those methods were private.
- We should not implement all these methods again in BouncingElasticBall because this would lead to duplication of code. So, we want to look for a way to reuse them.
- We cannot inherit BouncingElasticBall from both BouncingBall and ElasticBall. If they were interfaces, we could, but we can’t change the contract.
- Also, we should not inherit from only one class and rewrite methods from the other class because this would also lead to duplication of code and it doesn’t make any sense.
- So, we used composition to use private methods of BouncingBall and ElasticBall in BouncingElasticBall by making an object of them in our class and calling their update method.

  **Problem:**
  - If there is another functionality - Colourful, and we require a colourful bouncing ball, then we would have to make another class and similarly for every Permutation and combination.
  - Both balls are tightly coupled with BouncingElasticBall
