package com.codeup.spring_blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//public class RollDiceController {

    //take the input from the user and compare it with random number generator number
    //if random number matches number picked by user display "Your guessed right!"
    //if random number does not match number picked by user display "Your guess was incorrect.
    // The correct number is {randomnumber}

    @Controller
    public class RollDiceController {

        @GetMapping("/roll-dice")
        public String guess() {
            return "roll-dice";
        }

    @PostMapping("/roll-dice/{n}")
    public String diceRoll(@PathVariable int n, Model model){

            int random = (int)(Math.random() *6) + 1;

            boolean result = (random == n) ? true : false;

            model.addAttribute("n", n);
            model.addAttribute("random", random);
            model.addAttribute("result", result);

            return "roll-dice";


    }


}
