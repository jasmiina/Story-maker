import java.util.Random;

public class StoryGenerator{
  
  private StoryAttributes story;
  private Hero hero;
  private SecChar villain;
  private Tools t;
  private Boolean storyEnd; // If true, story ends and no more parts are generated
  
  public StoryGenerator(StoryAttributes story, Hero hero, SecChar villain){
    this.story = story;
    this.hero = hero;
    this.villain =villain;
    t = new Tools();
  }
  
  public String generateStory(){
    String generatedStory = "";
    storyEnd=false;
    generatedStory += generateBeginning();
    if(storyEnd==false){
      generatedStory += generateMiddle();
    }
    if(storyEnd==false){
      generatedStory += generateEnding();
    }
    generatedStory += System.lineSeparator() + "---END---";
    return generatedStory;
  }
  
  // Creates a string for the beginning of the story
  private String generateBeginning(){
    String beginning = "Our story starts in "+story.getSetting()+".";
    
    //1st paragraph
    if(story.getSetting() =="a forest"){
      beginning += " The tall trees dance in the wind, making the life living beneath them feel restless. The forest has suffered from a number of storms in the past month, and every fallen tree means a home or life lost.";
      if(story.getTime()=="past"){
        beginning += " But what the forest folk don't know is that ice age is coming, and their home will be gone soon nonetheless.";
      }
      if(story.getTime()=="present"){
        beginning += " But what the forest folk don't realize is that global warming has already passed the point of no return, and their home will be gone soon nonetheless.";
      }
      if(story.getTime()=="future"){
        beginning += " The forest is one of a kind, and should another storm come and wipe out the trees, the forest folk will have to spend a while looking for another place. After all, the Great Apocalypse wiped out two thirds of the already scarce fertile land.";
      }
    }
    
    if(story.getSetting() =="a palace"){
      beginning += " Grand exterior with golden roofs and marble floors make sure that its visitors will have no margin of error when it comes to the owner of this place - he's rich.";
      beginning += " But the 30 square kilometer land holds more than just one man, there's also the horses and servants and even a few house cats.";
      if(story.getTime()=="past"){
        beginning += " They're all doing their best to impress their owner, who is known as a ruthless, but rewarding man. Do as he says and do it better than he demands, and you'll get your compensation, but if you don't do your job correctly you can only hope for the least bad possibility.";
      }
      if(story.getTime()=="present"){
        beginning += " Of course, they're all actors trying to mimic the palace's past life, doing their best to impress paying visitors. Thanks to tax raises made by the government, simple entertainment such as this is becoming more and more of a luxury that only a few can afford. Therefore there's no room for error, and the actors can break character only once their shift is over.";
      }
      if(story.getTime()=="future"){
        beginning += " It's an honor for anyone to live on this land, since it's one of the only three ancient palaces that have survived to this day. Memories of the past are fading, and only a few lucky people are able to see it with their own eyes.";
        beginning += " They can, of course, enter an 87% life-like simulation of it, but actually seeing it live even from afar is something most folk don't have the willpower to do in this day and age.";
      }
    }
    
    if(story.getSetting() =="a town"){
      beginning += " It's by no means a big city, but its narrow streets are bustling with life. People are going and coming, someone is throwing fruits to the street from their window and another one is trying to catch them in hopes of actually getting to eat some lunch today.";
      if(story.getTime()=="past"){
        beginning += " The fruits are actually rotten, but beggars can't be choosers when the year's been bad for the crops and the nearby stalls are selling apples for 5 pelts a piece.";
      }
      if(story.getTime()=="present"){
        beginning += " Poverty has been on the rise lately, and some have no choice but to take desperate measures. Street beggars are not qualified for welfare, after all.";
      }
      if(story.getTime()=="future"){
        beginning += " The poor fellow has probably just entered the city from the Outside, which has been a wasteland ever since the Great Apocalypse.";
        beginning += " He doesn't seem to know that all food has been mass produced synthetically for a while now and anyone can enjoy three-course meals with the press of a button.";
      }
    }
    
    //2nd paragraph
    beginning += System.lineSeparator()+" But our hero is not concerned with such matters. They have more important things to worry about, as their mind is filled with thoughts of how they can " +hero.doTheGoal().toLowerCase() +".";
    beginning += " The pensive "+ t.removeArticles(hero.getSpecies())+" is actually";
    if(hero.getGoalObject().equals("money")){
      beginning += " looking through their wallet for the tenth time today. Money, money, money... their thoughts are filled with coins, cash, squirrel pelts and all the possible currencies that have or will exist.";
    }
    if(hero.getGoalObject().equals("a princess")){
      beginning += " daydreaming about princesses for the tenth time today. Makeup, gowns, romantic updos... what will it take to do it?";
    }
    if(hero.getGoalObject().equals("a gnome")){
      beginning += " flipping through pictures of small, bearded men for the tenth time today. They're not proud of their obsession, but it's all that keeps them going.";
    }
    if(hero.getGoalObject().equals("a cat")){
      beginning += " daydreaming about cats again for the tenth time today. Will the hair be soft or rough, will it have a pattern like stripes or perhaps even a heart?";
    }
    if(hero.getGoalObject().equals("a robot")){
      beginning += " daydreaming about robots again for the tenth time today. Should they just build one? No, it's too hard. Where could they even get the parts?";
    }
    if(hero.getGoalObject().equals("the world")){
      beginning += " staring at a world map for the tenth time today. Europe, Asia, Africa, even that tiny island off the shore of Australia. It's all so equally unobtainable.";
    }
    
    //3rd paragraph
    if(hero.getSpecies().equals("a human")){
      beginning +=System.lineSeparator()+ " 'I'm starting to wonder if I'll ever reach my goal. The future is looking hopeless',";
    }
    if(hero.getSpecies().equals("a gnome")){
      beginning +=System.lineSeparator()+ " 'Oi'm startin' ter wonder if i'll ever reach me goal. De future is lookin' a dead loss',";
    }
    if(hero.getSpecies().equals("a robot")){
      beginning +=System.lineSeparator()+ " 'I-AM-STARTING-TO-WONDER-IF-I-WILL-EVER-REACH-MY-GOAL. THE-FUTURE-IS-LOOKING-HOPELESS',";
    }
    if(hero.getSpecies().equals("a cat")){
      beginning +=System.lineSeparator()+ " 'Meow. Meow...',";
    }
    beginning +=" " + hero.getName() + " sighs while staring longinly at their";
    if(hero.getSpecies().equals("a cat")){
      beginning += " paws.";
    }
    else{
      beginning += " hands.";
    }
    
    if(hero.doTheGoal() .equals("become a cat") && hero.getSpecies().equals("a cat")){
      beginning +=System.lineSeparator()+ " '...Meow... Meow??!' But then our hero realises something. They're already a cat! 'Meow meow meow', the hero rejoices.";
      beginning +=System.lineSeparator() +" And so our story comes to a quick but happy end, as the hero realises they have already achieved their dream at the ripe age of " +hero.getAge() + "!";
      storyEnd = true;
      return beginning;
    }
    else if(hero.doTheGoal() .equals("become a gnome") && hero.getSpecies().equals("a gnome")){
      beginning +=System.lineSeparator()+ " 'Wait... me 'ands?!!' And then our hero realises something. There's no need to become a gnome, they already are one! 'Oi'm a gnum! oi'm alredy a gnum! 'oy de feck did oi not notice before?!', the hero rejoices.";
      beginning +=System.lineSeparator()+" And so our story comes to a quick but happy end, as the hero realises they have already achieved their dream at the ripe age of " +hero.getAge() + "!";
      storyEnd = true;
      return beginning;
    }
    else if(hero.doTheGoal() .equals("become a robot") && hero.getSpecies().equals("a robot")){
      beginning +=System.lineSeparator()+ " 'WAIT. MY-HANDS?' And then our hero realises something. There's no need to become a robot, they already are one! 'IT-SEEMS-I-AM-ALREADY-A-ROBOT. WHAT-A-PLEASANT-REALIZATION', the hero rejoices.";
      beginning +=System.lineSeparator()+" And so our story comes to a quick but happy end, as the hero realises they have already achieved their dream at the ripe age of " +hero.getAge() + "!";
      storyEnd = true;
      return beginning;
    }
    else{
      beginning += System.lineSeparator()+ " But then our hero is hit with a wave of resolve. No matter what, they have to achieve their dream. But being stuck in the same place is not helping, and so they've got to get out of this " + t.removeArticles(story.getSetting()) + "!";
    }
    
    return beginning;
    }
  
  // Returns a String of the story's middle part
  private String generateMiddle(){
    String m = System.lineSeparator() + " And so begins our hero's adventure.";
    
    if(story.getSetting().equals("a forest")){
      m += " The forest is thick with trees and footpaths are a rare occurrence, so getting out will be a challenge. There's also the dangerous animals one might face if they're unlucky enough.";
    }
    if(story.getSetting().equals("a palace")){
      m += " The palace grounds are huge, so the way out takes a while. And because "+hero.getName()+" is just a servant who's also supposed to be doing their shift at the moment, they can't let anyone see them. Looking around they realize that the courtyard is thick with people, but there's not enough of a crowd to blend in. They've no choice but to get creative.";
    }
    if(story.getSetting().equals("a town")){
      m += " The town area is quite large, so it will take a while to get out. The narrow streets are also filled with unmannered people who take great pleasure in blocking others' way.";
    }
   
     if(hero.getAgeGroup().equals("baby")){
        m +=" "+ hero.getName() + " is also a baby, so moving forward could turn out to be a bit troublesome. But luckily, our little " + t.removeArticles(hero.getSpecies()) + " is determined to put one foot in front of the other and start crawling!";
      }
      if(hero.getAgeGroup().equals("child") || hero.getAgeGroup().equals("teen")){
        m += " But our young " + hero.getName() + " is full of youthful energy and determination. Nothing will stop them on this important quest, and they start running through the obstacles!";
      }
      if(hero.getAgeGroup().equals("adult")){
        m += " But our " + hero.getName() + " is full of determination. Nothing will stop them on this important quest, and they start walking through the obstacles.";
    }
      if(hero.getAgeGroup().equals("elder")){
        m += " But our " + hero.getName() + " is full of determination. Nothing will stop them on this important quest, and despite their mature bones the elder " + t.removeArticles(hero.getSpecies()) + " starts walking through the obstacles.";
    }
      if(hero.getAgeGroup().equals("antique")){
        m += " But our " + hero.getName() + " is full of determination. They've gone through far more challenging experiences in their long, long lifetime, and nothing will stop this " + hero.getAge()+ "-year-old on this important quest. Despite their mature bones the elder " + t.removeArticles(hero.getSpecies()) + " starts walking through the obstacles.";
    }
    
    m += System.lineSeparator()+ " Around the midway of the journey the hero suddenly comes to a full stop, as they see something peculiar in front of them. A stranger.";
    if(hero.getSpecies().equals("a human")){
      m +=System.lineSeparator() +" 'I can't believe my eyes! What is that?',";
    }
    if(hero.getSpecies().equals("a gnome")){
      m +=System.lineSeparator() +" 'Oi canny believe me eyes! Whats da?',";
    }
    if(hero.getSpecies().equals("a robot")){
      m += System.lineSeparator() +" 'I-CAN-NOT-BELIEVE-MY-EYES. WHAT-IS-THAT?',";
    }
    if(hero.getSpecies().equals("a cat")){
      m +=System.lineSeparator() +" 'Meow!! Meow?',";
    }
    m+=" "+hero.getName()+" exclaims.";
    
    if(story.getGenre().equals("romance")){
      m += " It's the most beautiful creature they have ever seen. The fur, the color, the gorgeous eyes... "+hero.getName()+" is almost speechless. But it's rare to meet a beauty like that, so the hero gathers all their courage and asks:";
      if(hero.getSpecies().equals("a human")){
      m +=System.lineSeparator() +" 'W-what are you?'";
      }
      if(hero.getSpecies().equals("a gnome")){
        m +=System.lineSeparator() +" 'Waaat in de worlds ye supposed ter be?'";
      }
      if(hero.getSpecies().equals("a robot")){
        m += System.lineSeparator() +" 'WHAT-IS-YOUR-SPECIES?'";
      }
      if(hero.getSpecies().equals("a cat")){
        m +=System.lineSeparator() +" 'Meow meooow?'";
      }
      m += System.lineSeparator() + " 'I am "+ story.getStranger()+". And what are you? I've never seen your like before', the stranger wonders with a velvety voice.";
      if(hero.getSpecies().equals("a human")){
      m +=System.lineSeparator() +" 'I'm a human. Uhh, we're not that rare actually, it's strange that you've never seen one',";
      }
      if(hero.getSpecies().equals("a gnome")){
        m +=System.lineSeparator() +" 'Oi'm a gnum! We're a rarity raun 'ere, so 'tis not a surprise.',";
      }
      if(hero.getSpecies().equals("a robot")){
        m += System.lineSeparator() +" 'I-AM-CALLED-A-ROBOT',";
      }
      if(hero.getSpecies().equals("a cat")){
        m +=System.lineSeparator() +" 'Meow meow',";
      }
       m+=" "+hero.getName()+" answers. The two exchange pleasantries for a while, until the stranger expresses a proposition.";
       m+=System.lineSeparator() + " '" + hero.getName()+ ", it has been so nice to meet you. I know this may be too soon to ask, but would you like to marry me?'";
       m += System.lineSeparator() + " What! The hero is completely perplexed. Marriage has never crossed their mind, they've always been so focused on their goal. But their beating heart is a telltale sign, and so the hero gladly accepts the proposal.";
       m+=  " Now the only problem is to find a place that would let "+hero.getSpecies() + " and " +story.getStranger()+ " to get married. Now the hero is faced with a new goal!";
    }
    if(story.getGenre().equals("horror")){
       m += " The hero is not sure what they're looking at.";
       if(story.getStranger().equals("a bunny")){
         m+= " The strange creature has long, weird ears, and a cotton ball stuck to their butt. Its fur is white, but not spotless. Upon closer inspection, the spots look like faded blood stains.";
       }
        if(story.getStranger().equals("a lion")){
         m+= " The strange creature is absolutely massive in size and has a majestic, but fluffy mane . Its fur is a combination of varying hues of brown, and upon closer inspection it looks like there's faded blood stains blended in.";
       }
        if(story.getStranger().equals("a bee")){
         m+= " In fact, they can barely see the tiny creature. It's like a little ball of black fluff with yellow stripes and tiny legs. Upon closer inspection, there's also some reddish spots on the fluff that look like faded blood stains.";
       }
        m += " It might as well be a statue, as it's just standing a couple meters away staring at " +hero.getName()+ " without even blinking. The hero gathers some courage to open their mouth.";
        if(hero.getSpecies().equals("a human")){
           m +=System.lineSeparator() +" 'Is there something on my face? Do you want something?'";
         }
         if(hero.getSpecies().equals("a gnome")){
           m +=System.lineSeparator() +" 'Is dare somethin' on me bake? Waaat is it dat yer want?'";
         }
         if(hero.getSpecies().equals("a robot")){
           m += System.lineSeparator() +" 'IS-THERE-SOMETHING-ON-MY-FACE? DO-YOU-WANT-SOMETHING?'";
         }
         if(hero.getSpecies().equals("a cat")){
           m +=System.lineSeparator() +" 'Meow?'";
         }
         m += ", they ask with a shaky voice.";
         m += System.lineSeparator() + " But the creature doesn't answer. They just keep staring, and "+hero.getName()+" is starting to grow annoyed. They don't have time for this, they have goals to achieve!";
         if(hero.getSpecies().equals("a human")){
           m +=System.lineSeparator() +" 'Okaaay, so I really need to go now, can you please move out of my way?'";
         }
         if(hero.getSpecies().equals("a gnome")){
           m +=System.lineSeparator() +" 'Gran', so oi really nade ter go nigh, can yer please move oyt av me way?'";
         }
         if(hero.getSpecies().equals("a robot")){
           m += System.lineSeparator() +" 'I-NEED-TO-LEAVE. PLEASE-MOVE.'";
         }
         if(hero.getSpecies().equals("a cat")){
           m +=System.lineSeparator() +" 'Meooow, meow meow?'";
         }
         m += System.lineSeparator() + " But then suddenly the stranger's mouth starts moving. It's slowly forming a smile that reveals a row of sharp teeth, and it says:";
         m += System.lineSeparator() + " 'Y??u l??k delici??ussssss. C?n mee... eet y???uu?' After getting the words out, its mouth starts opening until the smile is gone and it's the shape of an 'o'.";
         m += " At that point the hero has completely forgotten about their goal and the only thing on their mind is that they have to get out of here, so they turn around and start running!";
         m += " But the creature starts chasing them, and it's much faster than "+hero.getName()+". It quickly catches up, and its mouth grows wider and wider until it could swallow the poor "+t.removeArticles(hero.getSpecies())+" whole.";
         m += System.lineSeparator() + " And that is exactly what it does, as it wraps its lips around "+hero.getName()+" and bites down.";
         storyEnd = true;
    }
    if(story.getGenre().equals("adventure")){
         m+= " The stranger is glowing with a golden hue, it's like there's an aura around them. The hero is completely speechless, and the stranger breaks the silence:";
         m+= System.lineSeparator() + " 'My name is Cala'udhan, but you can call me " +story.getStranger()+". I come from a land of riches and wonder, and you can be very pleased to hear that I have a proposition for you.' The stranger takes a deep breath and continues.";
         m+= System.lineSeparator() + " 'You see, I know about your goal. I know you want to "+hero.doTheGoal()+". But it's not so easy, is it?' The hero shakes their head, and the "+t.removeArticles(story.getStranger())+" gives a content smile.";
         m += System.lineSeparator()+ " 'I can help you, but you have to do something for me first.'";
         if(hero.getSpecies().equals("a human")){
           m +=System.lineSeparator() +" 'How can you help me? And how would I have to help you?'";
         }
         if(hero.getSpecies().equals("a gnome")){
           m +=System.lineSeparator() +" 'Well 'oy in de worlds can yer 'elp me? An' why wud oi 'elp yer?'";
         }
         if(hero.getSpecies().equals("a robot")){
           m += System.lineSeparator() +" 'CAN-I-HEAR-THE-TERMS?'";
         }
         if(hero.getSpecies().equals("a cat")){
           m +=System.lineSeparator() +" 'Meow?'";
         }
         m+=" "+hero.getName()+" asks with a doubtful, yet hopeful spark in their eye.";
         m += System.lineSeparator()+ " 'Very good question! I'm actually a fairy', the stranger says as they gesture around their aura. 'And there is a treasure hidden somewhere in this "+t.removeArticles(story.getSetting())+". I want you to find it. Bring it to me, and I will grant you a wish.";
         m += " The hero ponders for a while, until they decide to accept the offer. It seems that they now have a new quest in front of them!";
    }
     
    return m;
  }
  
  private String generateEnding(){
    String e = "";
    
    e += System.lineSeparator() + " And so with the new goal in mind the hero continues their journey. But they don't get far, as they meet another face. But this time, it's not a stranger.";
    if(hero.getSpecies().equals("a human")){
           e +=System.lineSeparator() +" 'You! What are you doing here?!'";
    }
    if(hero.getSpecies().equals("a gnome")){
           e +=System.lineSeparator() +" 'Yer! Wat are ye at 'ere?!?'";
    }
    if(hero.getSpecies().equals("a robot")){
           e += System.lineSeparator() +" 'IT-IS-YOU. WHAT-ARE-YOU-DOING-HERE?'";
    }
    if(hero.getSpecies().equals("a cat")){
           e +=System.lineSeparator() +" 'Meow!! Meow!?'";
    }
    e+=", "+hero.getName()+" yells as they see the face of their archnemesis "+villain.getName()+".";
    
    if(villain.getSpecies().equals("a human")){
           e +=System.lineSeparator() +" 'Hah! Surprised, are you? Thought I wouldn't hear about your little journey?'";
    }
    if(villain.getSpecies().equals("a gnome")){
           e +=System.lineSeparator() +" 'Ha! Gobsmacked, er ye? Tart oi wouldn't 'ear aboyt yisser wee journey?'";
    }
    if(villain.getSpecies().equals("a robot")){
           e += System.lineSeparator() +" 'HA-HA. SURPRISED, ARE-YOU? THOUGHT-I-WOULDN'T-HEAR-ABOUT-YOUR-LITTLE-JOURNEY?'";
    }
    if(villain.getSpecies().equals("a cat")){
           e +=System.lineSeparator() +" 'Meow! Meow meow meoow?'";
    }
    e+= ", the mad "+villain.getSpecies()+" taunts.";
    
    if(villain.getSpecies().equals("a human")){
           e +=" 'Well it's over now. I've come to stop you!'";
    }
    if(villain.getSpecies().equals("a gnome")){
           e +=" 'Well 'tis over nigh. Ah've come ter stop yer!'";
    }
    if(villain.getSpecies().equals("a robot")){
           e += " 'IT-IS-OVER-NOW. I-HAVE-COME-TO-STOP-YOU.'";
    }
    if(villain.getSpecies().equals("a cat")){
           e +=" 'Meow meoow!'";
    }
    e+= System.lineSeparator() + " But the hero is not impressed. "+villain.getName()+" has tried to stop them many times before. For some reason, they're really against their goal to "+hero.doTheGoal().toLowerCase()+".";
    
    //IF ROMANCE
    if(story.getGenre().equals("romance")){
      if(hero.getSpecies().equals("a human")){
        e +=System.lineSeparator() +" 'You fool! I have a new goal now! I'm going to marry them'";
      }
      if(hero.getSpecies().equals("a gnome")){
        e +=System.lineSeparator() +" 'Yer fool! Oi 'av a new goal nigh! Oi'm gonna marry dem'";
      }
      if(hero.getSpecies().equals("a robot")){
        e += System.lineSeparator() +" 'YOU-FOOL. I-HAVE-A-NEW-GOAL-NOW, I-AM-GOING-TO-MARRY-THEM'";
      }
      if(hero.getSpecies().equals("a cat")){
        e +=System.lineSeparator() +" 'Meow! Meow meow! Meow'";
      }
      e+= ", "+hero.getName()+" declares and gestures towards their "+t.removeArticles(story.getStranger())+" companion.";
      
      e+= System.lineSeparator() + " The nemesis gasps and furrows their brows.";
      //hates
      if(villain.getFeels().equals("hates")){
           if(villain.getSpecies().equals("a human")){
           e +=" 'No! My life goal is to make sure that you will never reach happiness, and as long as my heart is beating I will stop you!'";
           }
           if(villain.getSpecies().equals("a gnome")){
             e +=" 'Naw! Me life goal is ter make sure dat yer will never reach 'appiness, an' as long as me belly is roun' an' me beard is shinin', oi 'ill stop yer!'";
           }
           if(villain.getSpecies().equals("a robot")){
             e += " 'NO. I-WILL-NOT-LET-YOU-REACH-HAPPINESS!'";
           }
           if(villain.getSpecies().equals("a cat")){
             e +=" 'Meow! Meooow.... Murr!'";
           }
      }
      //loves
      if(villain.getFeels().equals("loves")){
           if(villain.getSpecies().equals("a human")){
           e +=" 'I can't let you do that! You know I'm the only one for you, I will not let you marry someone else!'";
           }
           if(villain.getSpecies().equals("a gnome")){
             e +=" 'Oi canny let yer chucker dat! Yer know oi'm de only wan for yer, oi will not let yer marry someone else!'";
           }
           if(villain.getSpecies().equals("a robot")){
             e += " 'I-CANNOT-LET-YOU-DO-THAT. I-AM-THE-ONLY-ONE-FOR-YOU, I-CANNOT-LET-YOU-MARRY-SOMEONE-ELSE.'";
           }
           if(villain.getSpecies().equals("a cat")){
             e +=" 'Murr... meow meow!'";
           }
      }
      //wants to eat
      if(villain.getFeels().equals("wants to eat")){
           if(villain.getSpecies().equals("a human")){
           e +=" 'No! I can't let you do that, your delicious flesh belongs to me!'";
           }
           if(villain.getSpecies().equals("a gnome")){
             e +=" 'Naw! Oi canny let yer do dat, yisser delicious flesh belongs ter me!'";
           }
           if(villain.getSpecies().equals("a robot")){
             e += " 'I-CANNOT-LET-YOU-DO-THAT. YOUR-DELICIOUS-FLESH-BELONGS TO ME.'";
           }
           if(villain.getSpecies().equals("a cat")){
             e +=" 'Meow! Meoooww!'";
           }
      }
      
      e+=System.lineSeparator()+" To the others' surprise, "+villain.getName()+" then pulls a knife out of their pocket and throws it straight to the poor "+t.removeArticles(story.getStranger())+"'s heart.";
       if(hero.getSpecies().equals("a human")){
        e +=System.lineSeparator() +" 'Noooo! My love! What have you done?!'";
      }
      if(hero.getSpecies().equals("a gnome")){
        e +=System.lineSeparator() +" 'Naaaw! Me love! Wat hav yer done!?'";
      }
      if(hero.getSpecies().equals("a robot")){
        e += System.lineSeparator() +" 'NO. MY-LOVE. WHAT-HAVE-YOU-DONE?'";
      }
      if(hero.getSpecies().equals("a cat")){
        e +=System.lineSeparator() +" 'Meooooow! Meow meow... murr?'";
      }
      e+= ", "+hero.getName()+" cries and gives a murderous look to "+villain.getName()+"'s direction. But the killer shows no signs of remorse.";
    
    //hates
      if(villain.getFeels().equals("hates")){
           if(villain.getSpecies().equals("a human")){
           e +=System.lineSeparator() +" 'Hah! The tears on your eyes give me great pleasure. Maybe I should kill you too to freeze that expression on your face forever!'";
           }
           if(villain.getSpecies().equals("a gnome")){
             e +=System.lineSeparator() +" 'Hah! Dem tears on yer eyes gie me deadly pleasure. Maybe oi shud kill yer too ter freeze dat expression on yiss face forever!'";
           }
           if(villain.getSpecies().equals("a robot")){
             e +=System.lineSeparator() + " 'YOUR-TEARS-GIVE-ME-PLEASURE. MAYBE-I-SHOULD-KILL-YOU-TOO-TO-FREEZE-THAT-EXPRESSION-FOREVER.'";
           }
           if(villain.getSpecies().equals("a cat")){
             e +=System.lineSeparator() +" 'Meow! Meow meow meow. Meow meow!'";
           }
           e += System.lineSeparator()+" But the hero has had enough. They grab the knife stuck to their lover's body, and throw it straight to "+villain.getName()+"'s face!";
           e+= " The villain doesn't even get a chance to realize what is happening, as they fall to the ground with trembling legs. "+hero.getName()+" stares at the body for a bit, but they feel no joy. They've killed the biggest obstacle in front of their original goal, but that doesn't matter anymore. Right now all they yearn for is to feel their love's heart beat again.";
           e += System.lineSeparator() + " But that will never happen again, and so "+hero.getName()+" spent the rest of their life in pain and solitude.";
      }
      //loves
      if(villain.getFeels().equals("loves")){
           if(villain.getSpecies().equals("a human")){
           e +=System.lineSeparator() +" 'Now you and I can be together. Just as two, forever.'";
           }
           if(villain.getSpecies().equals("a gnome")){
             e +=System.lineSeparator() +" 'Nigh yer an' oi can be together, forever.'";
           }
           if(villain.getSpecies().equals("a robot")){
             e +=System.lineSeparator() + " 'NOW-WE-CAN-BE-TOGETHER. FOREVER.'";
           }
           if(villain.getSpecies().equals("a cat")){
             e +=System.lineSeparator() +" 'Meow!'";
           }
           
            e += System.lineSeparator()+" But the hero only feels disgust towards their lover's murderer. However, their heart is filled with loneliness. They don't care about their original goal no longer, and it seems that there's nothing to drive them forward.";
           if(hero.getSpecies().equals("a human")){
             e +=System.lineSeparator() +" 'I don't care anymore. Just do what you want'";
           }
           if(hero.getSpecies().equals("a gnome")){
             e +=System.lineSeparator() +" 'Oi don't care naw more. Jist do wat yer want'";
           }
           if(hero.getSpecies().equals("a robot")){
             e +=System.lineSeparator() + " 'I-DO-NOT-CARE-ANY-MORE. DO-AS-YOU-WISH'";
           }
           if(hero.getSpecies().equals("a cat")){
             e +=System.lineSeparator() +" 'Meow...'";
           }
           e+= ", "+hero.getName()+" admits with a dejected tone. "+villain.getName()+"'s face lights up, and they promise to love their former nemesis with all their heart.";
           e+= System.lineSeparator()+ " And so the two spend the rest of their lives together in the "+t.removeArticles(story.getSetting())+". "+hero.getName()+" slowly develops a Stockholm syndrome, and so they both live happily ever after.";
      }
      //wants to eat
      if(villain.getFeels().equals("wants to eat")){
           if(villain.getSpecies().equals("a human")){
           e +=System.lineSeparator() +" 'HAHA! I've decided I will eat you both! Together you will taste exquisite. Now come here and I'll kill you too!'";
           }
           if(villain.getSpecies().equals("a gnome")){
             e +=System.lineSeparator() +" 'Haha! Ah've decided oi 'ill ayte yer both! Together yer 'ill taste exquisite. Nigh cum 'ere an' i'll kill yer too!'";
           }
           if(villain.getSpecies().equals("a robot")){
             e +=System.lineSeparator() + " 'HA-HA. I-HAVE-DECIDED-TO-EAT-YOU-BOTH. TOGETHER-YOU-WILL-TASTE-EXQUISITE. NOW-LET-ME-KILL-YOU-TOO.'";
           }
           if(villain.getSpecies().equals("a cat")){
             e +=System.lineSeparator() +" 'MEOW! Meoooww meow!'";
           }
           e += System.lineSeparator()+" But the hero has had enough. They grab the knife stuck to their lover's body, and throw it straight to "+villain.getName()+"'s face!";
           e+= " The villain doesn't even get a chance to realize what is happening, as they fall to the ground with trembling legs. "+hero.getName()+" stares at the body for a bit, until they realize they're actually quite hungry. They haven't eaten since starting the journey.";
           if(hero.getSpecies().equals("a human")){
             e +=System.lineSeparator() +" 'Well... I guess it doesn't hurt to try'";
           }
           if(hero.getSpecies().equals("a gnome")){
             e +=System.lineSeparator() +" 'Well... oi guess it don't hurt ter try'";
           }
           if(hero.getSpecies().equals("a robot")){
             e +=System.lineSeparator() + " 'I-HAVE-COME-TO-THE-CONCLUSION-THAT-IT-DOESN'T-HURT-TO-TRY'";
           }
           if(hero.getSpecies().equals("a cat")){
             e +=System.lineSeparator() +" 'Meow...'";
           }
           e+= ", they conclude and start tearing into their archnemesis' meat.";
      }
    }
      
      //IF ADVENTURE
    if(story.getGenre().equals("adventure")){
      if(hero.getSpecies().equals("a human")){
        e +=System.lineSeparator() +" 'Why are you so against me achieving my goals? What's your problem?'";
      }
      if(hero.getSpecies().equals("a gnome")){
        e +=System.lineSeparator() +" 'Why ye so against me achievin' me goals? Wat's yer problem?'";
      }
      if(hero.getSpecies().equals("a robot")){
        e += System.lineSeparator() +" 'WHY-ARE-YOU-SO-AGAINST-ME-ACHIEVING-MY-GOALS. WHAT-IS-YOUR-PROBLEM?'";
      }
      if(hero.getSpecies().equals("a cat")){
        e +=System.lineSeparator() +" 'Meow meow, meow?'";
      }
      e+= ", "+hero.getName()+" questions.";
      
      e+= System.lineSeparator() + " The nemesis crosses their arms and declares their feelings.";
      //hates
      if(villain.getFeels().equals("hates")){
           if(villain.getSpecies().equals("a human")){
           e +=" 'Because I hate you!! My life goal is to make sure that you will never reach happiness, and as long as my heart is beating I will stop you!'";
           }
           if(villain.getSpecies().equals("a gnome")){
             e +=" 'Cos oi hate yer!! Me life goal is ter make sure dat yer will never reach 'appiness, an' as long as me belly is roun' an' me beard is shinin', oi 'ill stop yer!'";
           }
           if(villain.getSpecies().equals("a robot")){
             e += " 'BECAUSE-I-HAVE-NEGATIVE-FEELINGS-TOWARDS-YOU. I-WILL-NOT-LET-YOU-REACH-HAPPINESS.'";
           }
           if(villain.getSpecies().equals("a cat")){
             e +=" 'Meow! Meooow.... Murr!'";
           }
      }
      //loves
      if(villain.getFeels().equals("loves")){
           if(villain.getSpecies().equals("a human")){
           e +=" 'Because I love you! Your goals only get in the way of our love!'";
           }
           if(villain.getSpecies().equals("a gnome")){
             e +=" 'Cos oi love yer! Yer goals only git in de way av our love!!'";
           }
           if(villain.getSpecies().equals("a robot")){
             e += " 'BECAUSE-I-HAVE-ROMANTIC-FEELINGS-TOWARDS-YOU. YOUR-GOALS-ARE-IN-THE-WAY-OF-OUR-LOVE'";
           }
           if(villain.getSpecies().equals("a cat")){
             e +=" 'Meow! Meow meow...!'";
           }
      }
      //wants to eat
      if(villain.getFeels().equals("wants to eat")){
           if(villain.getSpecies().equals("a human")){
           e +=" 'Because I think you look delicious! I don't care about your goals, I just want to cook your meat and eat it!'";
           }
           if(villain.getSpecies().equals("a gnome")){
             e +=" 'Cos oi tink yer luk delicious! Oi don't care aboyt yer goals, oi jist want ter cook yer meat an' ayte it!'";
           }
           if(villain.getSpecies().equals("a robot")){
             e += " 'YOUR-MEAT-TEMPTS-ME. I-DO-NOT-CARE-ABOUT-YOUR-GOALS, I-JUST-WANT-TO-COOK-AND-EAT-YOU.'";
           }
           if(villain.getSpecies().equals("a cat")){
             e +=" 'Meow! Meoooww!'";
           }
      }
      
      e+=System.lineSeparator()+" "+hero.getName()+" grows even more agitated after hearing the answer. Maybe they should just try to get rid of the stupid "+t.removeArticles(villain.getSpecies())+" for good.";
      e+= " They pull a knife out of their pocket, and point it towards their nemesis.";
       if(hero.getSpecies().equals("a human")){
        e +=System.lineSeparator() +" 'If you dare to come any closer, I will kill you!'";
      }
      if(hero.getSpecies().equals("a gnome")){
        e +=System.lineSeparator() +" 'If yer dare ter cum any closer, oi 'ill kill yer!'";
      }
      if(hero.getSpecies().equals("a robot")){
        e += System.lineSeparator() +" 'DO-NOT-MOVE-CLOSER-OR-I-WILL-USE-THIS-OBJECT-TO-KILL-YOU'";
      }
      if(hero.getSpecies().equals("a cat")){
        e +=System.lineSeparator() +" 'Meow meow!'";
      }
      e+= ", "+hero.getName()+" threatens and gives a murderous look to "+villain.getName()+"'s direction.";
    
    //hates
      if(villain.getFeels().equals("hates")){
           if(villain.getSpecies().equals("a human")){
           e +=System.lineSeparator() +" 'Hah! Let's see you try, you fool!'";
           }
           if(villain.getSpecies().equals("a gnome")){
             e +=System.lineSeparator() +" 'Hah! Let's clap yer try, yer eejit!'";
           }
           if(villain.getSpecies().equals("a robot")){
             e +=System.lineSeparator() + " 'HA-HA. LET-US-SEE-YOU-TRY.'";
           }
           if(villain.getSpecies().equals("a cat")){
             e +=System.lineSeparator() +" 'Meow! Meow, meow!'";
           }
           e += System.lineSeparator()+" "+villain.getName()+" grabs a knife from their pocket as well, and they both lunge for each other. They dance for a while, but it seems they're equally fast and strong.";
           e+= " But our hero has more wit. Surprising their opponent, they quickly retreat backwards and in the wave of confusion the villain doesn't even get a chance to realize what is happening, as "+hero.getName()+" throws the knife to their face!";
           e += System.lineSeparator() + " And so "+hero.getName()+" defeats their biggest obstacle. They were so filled with adrenaline that they forgot what their original goal was, but it doesn't matter anymore. They've tasted blood, and they yearn for more. Fighting becomes their biggest passion, and so they spend the rest of their life as a traveling adventurer seeking thrill!";
      }
      //loves
      if(villain.getFeels().equals("loves")){
           if(villain.getSpecies().equals("a human")){
           e +=System.lineSeparator() +" 'No! Don't do it, my love!'";
           }
           if(villain.getSpecies().equals("a gnome")){
             e +=System.lineSeparator() +" 'Naw! Don't do eet, me love!'";
           }
           if(villain.getSpecies().equals("a robot")){
             e +=System.lineSeparator() + " 'DO-NOT-DO-IT, PERSON-I-HAVE-ROMANTIC-FEELINGS-FOR'";
           }
           if(villain.getSpecies().equals("a cat")){
             e +=System.lineSeparator() +" 'Meow!'";
           }
           e+= ", "+villain.getName()+" begs. The hero is extremely annoyed, but they would feel bad hurting someone who loves them so. They drop the knife, and consider their options. The "+t.removeArticles(villain.getSpecies())+" is extremely annoying, but they also seem to care about the hero. They could turn out to be useful.";
           
           if(hero.getSpecies().equals("a human")){
             e +=System.lineSeparator() +" 'Fine. Instead, would you join me on my journey? We can be together, and I'll get more help. It's a win-win!'";
           }
           if(hero.getSpecies().equals("a gnome")){
             e +=System.lineSeparator() +" 'Fine. Instead, wud yer join me on me journey? We can be together, an' i'll git more 'elp. 'Tis a win-win!''";
           }
           if(hero.getSpecies().equals("a robot")){
             e +=System.lineSeparator() + " 'I-WILL-COMPLY. INSTEAD, WOULD-YOU-LIKE-TO-JOIN-ME-ON-MY-JOURNEY? WE-CAN-BE-TOGETHER, AND-I-WILL-GET-MORE-HELP. IT-IS-THE-LOGICAL-CONCLUSION'";
           }
           if(hero.getSpecies().equals("a cat")){
             e +=System.lineSeparator() +" 'Meow...'";
           }
           e+= ", "+hero.getName()+" suggests. "+villain.getName()+"'s face lights up, and they nod their head enthusiastically. Any chance to spend more time with their love is worth taking!";
           e+= System.lineSeparator()+ " And so the two continue their journey, first doing the deed the strange "+t.removeArticles(story.getStranger())+" asked. It turned out to be a hoax, but the pair didn't falter. Together they had more determination than anyone!";
      }
      //wants to eat
      if(villain.getFeels().equals("wants to eat")){
           if(villain.getSpecies().equals("a human")){
           e +=System.lineSeparator() +" 'Hah! Let's see you try, you fool!'";
           }
           if(villain.getSpecies().equals("a gnome")){
             e +=System.lineSeparator() +" 'Hah! Let's clap yer try, yer eejit!'";
           }
           if(villain.getSpecies().equals("a robot")){
             e +=System.lineSeparator() + " 'HA-HA. LET-US-SEE-YOU-TRY.'";
           }
           if(villain.getSpecies().equals("a cat")){
             e +=System.lineSeparator() +" 'Meow! Meow, meow!'";
           }
           e += System.lineSeparator()+" "+villain.getName()+" grabs a knife from their pocket as well, and they both lunge for each other. They dance for a while, but it seems they're equally fast and strong.";
           e+= " But our hero has more wit. Surprising their opponent, they quickly retreat backwards and in the wave of confusion the villain doesn't even get a chance to realize what is happening, as "+hero.getName()+" throws the knife to their face!";
           e+= " The hero stares at the trembling body, and realizes they're actually quite hungry. They haven't eaten since starting the journey.";
           if(hero.getSpecies().equals("a human")){
             e +=System.lineSeparator() +" 'Well... I guess it doesn't hurt to try'";
           }
           if(hero.getSpecies().equals("a gnome")){
             e +=System.lineSeparator() +" 'Well... oi guess it don't hurt ter try'";
           }
           if(hero.getSpecies().equals("a robot")){
             e +=System.lineSeparator() + " 'I-HAVE-COME-TO-THE-CONCLUSION-THAT-IT-DOESN'T-HURT-TO-TRY'";
           }
           if(hero.getSpecies().equals("a cat")){
             e +=System.lineSeparator() +" 'Meow...'";
           }
           e+= ", they conclude and start tearing into their archnemesis' meat.";
           e += System.lineSeparator() + " And so "+hero.getName()+" defeats their biggest obstacle. They were so filled with adrenaline that they forgot what their original goal was, but it doesn't matter anymore. They've tasted blood, and they yearn for more. "+t.capitalizeFirstLetter(t.removeArticles(villain.getSpecies()))+" meat becomes their biggest passion, and so they spend the rest of their life as "+villain.getSpecies()+" hunter!";
      }
    }
    return e;
  }
    
    /*private String generateSettingDescription(){
      Random rand = new Random();
      String[] desc = new String[]();
      if(story.getSetting()=="a forest"){
        desc[0] = "The tall trees dance in the wind, alerting the life living beneath them that this is no ordinary day. 
      return "r";
    }*/
  
}