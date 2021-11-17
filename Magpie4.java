public class Magpie4 {
	public String getGreeting() {
		return "Hello, my name is super chatbot";
	}

	public String getResponse(String statement) {




























































		String response = "";
		if (statement.length() == 0) {
			response = "Say something, please.";
		}
    else if (findKeyword(statement, "hello") >= 0 || findKeyword(statement, "hi") >= 0 || findKeyword(statement, "sup") >= 0 || findKeyword(statement, "What's up") >=0 ) {
      response = "Hi! What's your favorite superhero?";
    } else if(findKeyword(statement, "Iron Man") >= 0 || findKeyword(statement, "Ant-Man") >= 0 || findKeyword(statement, "Thor") >= 0 || findKeyword(statement, "Doctor Strange") >= 0 || findKeyword(statement, "Avengers: Age of Ultron") >= 0 || findKeyword(statement, "The Incredible Hulk") >= 0 ||findKeyword(statement, "Deadpool") >= 0 ||findKeyword(statement, "Venom") >= 0 ||findKeyword(statement, "Thor: Ragnarok") >= 0 ||findKeyword(statement, "Black Widow") >= 0 ||findKeyword(statement, "Ant-Man and the Wasp: Quantumania") >= 0 ||findKeyword(statement, "Spider-Man: Homecoming") >= 0 ||findKeyword(statement, "Spider Man") >= 0 ||findKeyword(statement, "Venom 2") >= 0 ||findKeyword(statement, "Black Panther") >= 0 ||findKeyword(statement, "Spider-Man: No Way Home") >= 0 ||findKeyword(statement, "Fantastic Four") >= 0 ||findKeyword(statement, "Doctor Strange in the Multiverse of Madness") >= 0 ||findKeyword(statement, "Eternals") >= 0 ||findKeyword(statement, "Doctor Strange in the Multiverse of Madness") >= 0 || findKeyword(statement, "Shang Chi") >=0 ) {
      response = "Wow, Thats my favorite movie too!";
      response = "It appears you like superheroes a lot, mind if I ask you some questions?";

   
   
   
   
   
   
   
    } 
     else if(findKeyword(statement,"yes") >= 0) {
      response = "What is the real name of Batman?";
     }
      else if(findKeyword(statement, "Bruce") >=0 || findKeyword(statement, "Bruce Wayne") >=0 || findKeyword(statement, "Wayne") >=0) {
        response = "Correct!";
      } else if(findKeyword(statement, "no") >= 0) {
        response = "Aww, why not?";
      } 
     else if(findKeyword(statement,"sure") >= 0) {
      response = "What Iron Man's Real name";
     }
      else if(findKeyword(statement, "Tony") >=0 || findKeyword(statement, " Tony Stark") >=0 || findKeyword(statement, "Stark") >=0) {
        response = "Correct!";
      }
    else if(findKeyword(statement,"fine") >= 0) {
      response = "Who plays the Marvel Cinematic Universe version of Spider Man in real life";
     }
      else if(findKeyword(statement, "Tom") >=0 || findKeyword(statement, " Tom Holland") >=0 || findKeyword(statement, "Holland") >=0) {
        response = "Correct!";
      }
    else if(findKeyword(statement,"Certaintly") >= 0) {
      response = "Who is Batman's main villain in The Dark Knight";
     }
      else if(findKeyword(statement, "Joker") >=0 || findKeyword(statement, "The Joker") >=0 || findKeyword(statement, "joker") >=0) {
        response = "Correct!";
      }
    else if(findKeyword(statement,"Yea") >= 0) {
      response = "Who is the main villian of the first Doctor Strange movie";
     }
      else if(findKeyword(statement, "Dormmamu") >=0 || findKeyword(statement, "dormmamu") >=0)  {
        response = "Correct!";
      }








		else if (findKeyword(statement, "no") >= 0) {
			response = "Why so negative?";
		}
		else if (findKeyword(statement, "I want to", 0) >= 0) {
			response = transformIWantToStatement(statement);
		}
		else {
			int psn = findKeyword(statement, "you", 0);

			if (psn >= 0 && findKeyword(statement, "me", psn) >= 0) {
				response = transformYouMeStatement(statement);
			}
			else {
				response = getRandomResponse(statement);
			}
		}
		return response;
	}

	private String transformIWantToStatement(String statement) {
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "What would it mean to " + restOfStatement + "?";
	}

	private String transformYouMeStatement(String statement) {
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement
					.length() - 1);
		}

		int psnOfYou = findKeyword (statement, "you", 0);
		int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);

		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}

	private int findKeyword(String statement, String goal, int startPos) {
		String phrase = statement.trim();
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

		while (psn >= 0) {
			String before = " ", after = " ";
			if (psn > 0) {
				before = phrase.substring (psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length()) {
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
			}
			if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0)) && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0))) {
				return psn;
			}
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
		}
		return -1;
	}

	private int findKeyword(String statement, String goal) {
		return findKeyword (statement, goal, 0);
	}

	private String getRandomResponse(String statement) {
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Huh? What does this mean?";
		}
		else if (whichResponse == 1) {
			response = "What does: "  + statement + " mean?";
		}
		else if (whichResponse == 2) {
			response = "I am confused :(";
		}
		else if (whichResponse == 3) {
			response = "?????";
		}
		return response;
	}
}
