package com.example.data

object SampleDataProvider {

    // --- HINDI LESSONS ---
    val hindiGreetingsPhrases = listOf(
        Phrase(
            id = "hi_p1",
            targetText = "नमस्ते",
            scriptText = "नमस्ते",
            transliteration = "Namaste",
            englishMeaning = "Hello / Greetings / Respectful welcome",
            nativeMeaning = "सादर अभिवादन या प्रणाम",
            exampleTarget = "नमस्ते! आप कैसे हैं?",
            exampleMeaning = "Hello! How are you?",
            audioHint = "na-mas-tay"
        ),
        Phrase(
            id = "hi_p2",
            targetText = "धन्यवाद",
            scriptText = "धन्यवाद",
            transliteration = "Dhanyavaad",
            englishMeaning = "Thank you",
            nativeMeaning = "आभार व्यक्त करना / शुक्रिया",
            exampleTarget = "आपकी मदद के लिए बहुत-बहुत धन्यवाद।",
            exampleMeaning = "Thank you very much for your help.",
            audioHint = "dhan-ya-vaad"
        ),
        Phrase(
            id = "hi_p3",
            targetText = "सुप्रभात",
            scriptText = "सुप्रभात",
            transliteration = "Suprabhaat",
            englishMeaning = "Good morning",
            nativeMeaning = "सुबह की मंगलकामना",
            exampleTarget = "सुप्रभात दोस्तों, आज का दिन शुभ हो!",
            exampleMeaning = "Good morning friends, have a great day!",
            audioHint = "su-pra-bhaat"
        ),
        Phrase(
            id = "hi_p4",
            targetText = "शुभ रात्रि",
            scriptText = "शुभ रात्रि",
            transliteration = "Shubh Raatri",
            englishMeaning = "Good night",
            nativeMeaning = "रात की विदाई व मंगलकामना",
            exampleTarget = "अब सोने का समय हो गया, शुभ रात्रि।",
            exampleMeaning = "Time to sleep now, good night.",
            audioHint = "shubh raa-tri"
        ),
        Phrase(
            id = "hi_p5",
            targetText = "अलविदा / फिर मिलेंगे",
            scriptText = "फिर मिलेंगे",
            transliteration = "Phir Milenge",
            englishMeaning = "See you again / Goodbye",
            nativeMeaning = "दोबारा मिलने की आशा के साथ विदा",
            exampleTarget = "कल शाम को दफ्तर में फिर मिलेंगे।",
            exampleMeaning = "We will meet again tomorrow evening at office.",
            audioHint = "phir mi-len-ge"
        )
    )

    val hindiDailyConversationPhrases = listOf(
        Phrase(
            id = "hi_conv_1",
            targetText = "आपका नाम क्या है?",
            scriptText = "आपका नाम क्या है?",
            transliteration = "Aapka naam kya hai?",
            englishMeaning = "What is your name?",
            nativeMeaning = "नाम पूछने का विनम्र तरीका",
            exampleTarget = "नमस्ते, मेरा नाम राहुल है। आपका नाम क्या है?",
            exampleMeaning = "Hello, my name is Rahul. What is your name?",
            audioHint = "aap-ka naam kya hai"
        ),
        Phrase(
            id = "hi_conv_2",
            targetText = "आप कैसे हैं?",
            scriptText = "आप कैसे हैं?",
            transliteration = "Aap kaise hain?",
            englishMeaning = "How are you? (Polite)",
            nativeMeaning = "कुशल-क्षेम पूछना",
            exampleTarget = "मैं बिल्कुल ठीक हूँ, आप कैसे हैं?",
            exampleMeaning = "I am totally fine, how are you?",
            audioHint = "aap kay-say hain"
        ),
        Phrase(
            id = "hi_conv_3",
            targetText = "यह कितने का है?",
            scriptText = "यह कितने का है?",
            transliteration = "Yeh kitne ka hai?",
            englishMeaning = "How much does this cost?",
            nativeMeaning = "मूल्य पूछना",
            exampleTarget = "भैया, यह किताब कितने की है?",
            exampleMeaning = "Brother, how much is this book?",
            audioHint = "yeh kit-nay ka hai"
        ),
        Phrase(
            id = "hi_conv_4",
            targetText = "माफ़ कीजियेगा",
            scriptText = "माफ़ कीजियेगा",
            transliteration = "Maaf kijiye gaa",
            englishMeaning = "Excuse me / I'm sorry",
            nativeMeaning = "क्षमा याचना या ध्यान आकर्षित करना",
            exampleTarget = "माफ़ कीजियेगा, क्या आप समय बता सकते हैं?",
            exampleMeaning = "Excuse me, can you please tell the time?",
            audioHint = "maaf kee-ji-ye-gaa"
        )
    )

    val hindiFoodTravelPhrases = listOf(
        Phrase(
            id = "hi_food_1",
            targetText = "मुझे बहुत भूख लगी है",
            scriptText = "मुझे बहुत भूख लगी है",
            transliteration = "Mujhe bohot bhookh lagi hai",
            englishMeaning = "I am very hungry",
            nativeMeaning = "भोजन की तीव्र आवश्यकता",
            exampleTarget = "चलिये कुछ खाते हैं, मुझे बहुत भूख लगी है।",
            exampleMeaning = "Let's eat something, I am very hungry.",
            audioHint = "mu-jhay bo-hot bhookh la-gee hai"
        ),
        Phrase(
            id = "hi_food_2",
            targetText = "खाना बहुत स्वादिष्ट है",
            scriptText = "खाना बहुत स्वादिष्ट है",
            transliteration = "Khaana bohot swaadisht hai",
            englishMeaning = "The food is very delicious",
            nativeMeaning = "भोजन की प्रशंसा",
            exampleTarget = "वाह! यह पनीर की सब्जी बहुत स्वादिष्ट है।",
            exampleMeaning = "Wow! This paneer dish is very delicious.",
            audioHint = "khaa-na swaa-disht hai"
        ),
        Phrase(
            id = "hi_food_3",
            targetText = "रेलवे स्टेशन कहाँ है?",
            scriptText = "रेलवे स्टेशन कहाँ है?",
            transliteration = "Railway station kahaan hai?",
            englishMeaning = "Where is the railway station?",
            nativeMeaning = "रास्ता या दिशा पूछना",
            exampleTarget = "क्षमा करें, क्या यहाँ से रेलवे स्टेशन पास है?",
            exampleMeaning = "Excuse me, is the railway station nearby from here?",
            audioHint = "ka-haan hai"
        )
    )

    // --- MARATHI LESSONS ---
    val marathiGreetingsPhrases = listOf(
        Phrase(
            id = "mr_p1",
            targetText = "नमस्कार",
            scriptText = "नमस्कार",
            transliteration = "Namaskar",
            englishMeaning = "Hello / Respectful greetings in Marathi",
            nativeMeaning = "आदरपूर्वक वंदन",
            exampleTarget = "नमस्कार! कसे आहात तुम्ही?",
            exampleMeaning = "Hello! How are you?",
            audioHint = "na-mas-kaar"
        ),
        Phrase(
            id = "mr_p2",
            targetText = "धन्यवाद / आभारी आहे",
            scriptText = "धन्यवाद",
            transliteration = "Dhanyavaad / Aabhari aahe",
            englishMeaning = "Thank you / I am grateful",
            nativeMeaning = "कृतज्ञता व्यक्त करणे",
            exampleTarget = "तुमच्या सहकार्याबद्दल खूप खूप धन्यवाद.",
            exampleMeaning = "Thank you very much for your cooperation.",
            audioHint = "dhan-ya-vaad"
        ),
        Phrase(
            id = "mr_p3",
            targetText = "शुभ सकाळ",
            scriptText = "शुभ सकाळ",
            transliteration = "Shubh Sakaal",
            englishMeaning = "Good morning",
            nativeMeaning = "सकाळच्या मंगल शुभेच्छा",
            exampleTarget = "सर्वांना शुभ सकाळ, आजचा दिवस छान जावो!",
            exampleMeaning = "Good morning to all, have a nice day!",
            audioHint = "shubh sa-kaal"
        ),
        Phrase(
            id = "mr_p4",
            targetText = "शुभ रात्री",
            scriptText = "शुभ रात्री",
            transliteration = "Shubh Raatri",
            englishMeaning = "Good night",
            nativeMeaning = "रात्रीच्या शुभेच्छा",
            exampleTarget = "आता विश्रांती घ्या, शुभ रात्री.",
            exampleMeaning = "Rest now, good night.",
            audioHint = "shubh raa-tri"
        ),
        Phrase(
            id = "mr_p5",
            targetText = "पुन्हा भेटू",
            scriptText = "पुन्हा भेटू",
            transliteration = "Punha Bhetu",
            englishMeaning = "See you again / Goodbye",
            nativeMeaning = "निरोप घेताना पुन्हा भेटण्याची इच्छा",
            exampleTarget = "आज निघतो, उद्या पुन्हा भेटू!",
            exampleMeaning = "Leaving today, see you again tomorrow!",
            audioHint = "pun-ha bhay-too"
        )
    )

    val marathiDailyConversationPhrases = listOf(
        Phrase(
            id = "mr_conv_1",
            targetText = "तुमचे नाव काय आहे?",
            scriptText = "तुमचे नाव काय आहे?",
            transliteration = "Tumche naav kaay aahe?",
            englishMeaning = "What is your name?",
            nativeMeaning = "नाव विचारण्याची नम्र पद्धत",
            exampleTarget = "नमस्कार, माझे नाव अमित आहे. तुमचे नाव काय आहे?",
            exampleMeaning = "Hello, my name is Amit. What is your name?",
            audioHint = "tum-chay naav kaay aa-hay"
        ),
        Phrase(
            id = "mr_conv_2",
            targetText = "तुम्ही कसे आहात?",
            scriptText = "तुम्ही कसे आहात?",
            transliteration = "Tumhi kase aahaat?",
            englishMeaning = "How are you? (Polite / Respectful)",
            nativeMeaning = "खुशहाली विचारणे",
            exampleTarget = "मी मजेत आहे, तुम्ही कसे आहात?",
            exampleMeaning = "I am doing great, how are you?",
            audioHint = "tum-hee ka-say aa-haat"
        ),
        Phrase(
            id = "mr_conv_3",
            targetText = "याची किंमत किती आहे?",
            scriptText = "याची किंमत किती आहे?",
            transliteration = "Yaachi kimmat kiti aahe?",
            englishMeaning = "How much does this cost?",
            nativeMeaning = "दुकानदाराला भाव विचारणे",
            exampleTarget = "दादा, या चहाची किंमत किती आहे?",
            exampleMeaning = "Brother, how much does this tea cost?",
            audioHint = "kim-mat ki-tee aa-hay"
        ),
        Phrase(
            id = "mr_conv_4",
            targetText = "मला समजले नाही",
            scriptText = "मला समजले नाही",
            transliteration = "Mala samajale naahi",
            englishMeaning = "I did not understand",
            nativeMeaning = "असमर्थता दर्शवणे",
            exampleTarget = "कृपया पुन्हा सांगा, मला समजले नाही.",
            exampleMeaning = "Please say again, I didn't understand.",
            audioHint = "sa-maj-lay naa-hee"
        )
    )

    // --- ENGLISH LESSONS ---
    val englishGreetingsPhrases = listOf(
        Phrase(
            id = "en_p1",
            targetText = "Pleasure to meet you",
            scriptText = "Pleasure to meet you",
            transliteration = "प्लेझर टू मीट यू",
            englishMeaning = "A polite greeting when meeting someone for the first time",
            nativeMeaning = "आपसे मिलकर बहुत खुशी हुई (Hindi) / तुम्हाला भेटून आनंद झाला (Marathi)",
            exampleTarget = "Hello Sarah, pleasure to meet you!",
            exampleMeaning = "नमस्ते सारा, आपसे मिलकर खुशी हुई!",
            audioHint = "pleh-zhur to meet yoo"
        ),
        Phrase(
            id = "en_p2",
            targetText = "Could you please help me?",
            scriptText = "Could you please help me?",
            transliteration = "कुड यू प्लीज हेल्प मी?",
            englishMeaning = "Polite request for assistance",
            nativeMeaning = "क्या आप कृपया मेरी मदद कर सकते हैं? / कृपया मला मदत कराल का?",
            exampleTarget = "Excuse me, could you please help me find the gate?",
            exampleMeaning = "माफ़ कीजिये, क्या आप मुझे गेट खोजने में मदद कर सकते हैं?",
            audioHint = "kood yoo pleez help mee"
        ),
        Phrase(
            id = "en_p3",
            targetText = "Have a great day ahead",
            scriptText = "Have a great day ahead",
            transliteration = "हॅव अ ग्रेट डे अहेड",
            englishMeaning = "Wishing someone a pleasant remainder of their day",
            nativeMeaning = "आपका आने वाला दिन शुभ हो / पुढचा दिवस चांगला जावो",
            exampleTarget = "Thanks for the coffee! Have a great day ahead.",
            exampleMeaning = "कॉफ़ी के लिए धन्यवाद! आपका दिन शुभ हो।",
            audioHint = "hav a grayt day a-hed"
        ),
        Phrase(
            id = "en_p4",
            targetText = "I really appreciate it",
            scriptText = "I really appreciate it",
            transliteration = "आय रियली अप्रिशिएट इट",
            englishMeaning = "Sincere expression of gratitude",
            nativeMeaning = "मैं वास्तव में इसकी सराहना करता हूँ / मला याचे मनःपूर्वक कौतुक आहे",
            exampleTarget = "You solved the issue so fast, I really appreciate it!",
            exampleMeaning = "आपने समस्या इतनी जल्दी हल कर दी, बहुत आभारी हूँ!",
            audioHint = "i ree-a-lee uh-pree-shee-ayt it"
        )
    )

    val englishFluencyPhrases = listOf(
        Phrase(
            id = "en_fl_1",
            targetText = "Let's touch base tomorrow",
            scriptText = "Let's touch base tomorrow",
            transliteration = "लेट्स टच बेस टुमॉरो",
            englishMeaning = "Let's briefly talk or follow up tomorrow",
            nativeMeaning = "कल संक्षेप में बात करते हैं / उद्या परत चर्चा करूया",
            exampleTarget = "I'll review the draft and let's touch base tomorrow morning.",
            exampleMeaning = "मैं मसौदे की समीक्षा करूँगा और कल सुबह बात करेंगे।",
            audioHint = "touch base"
        ),
        Phrase(
            id = "en_fl_2",
            targetText = "That makes total sense",
            scriptText = "That makes total sense",
            transliteration = "दॅट मेक्स टोटल सेन्स",
            englishMeaning = "I completely understand and agree with your logic",
            nativeMeaning = "यह बात बिल्कुल समझ आती है और सही है / हे अगदी पटण्यासारखे आहे",
            exampleTarget = "Ah, now that makes total sense. Thank you!",
            exampleMeaning = "अरे, अब यह बात पूरी तरह समझ में आई। धन्यवाद!",
            audioHint = "toh-tul sens"
        )
    )

    val categories: List<LessonCategory> = listOf(
        // Hindi categories
        LessonCategory(
            id = "hi_cat_1",
            language = AppLanguage.HINDI,
            title = "Greetings & Courtesies",
            nativeTitle = "अभिवादन और शिष्टाचार",
            icon = "👋",
            description = "Master essential polite Hindi greetings used across India every day.",
            level = DifficultyLevel.BEGINNER,
            lessons = listOf(
                Lesson(
                    id = "hi_greet_1",
                    categoryId = "hi_cat_1",
                    title = "Essential Greetings",
                    nativeTitle = "मूलभूत अभिवादन",
                    summary = "Learn Namaste, Dhanyavaad, Suprabhaat and respectful ways to address others.",
                    phrases = hindiGreetingsPhrases,
                    xpReward = 45
                )
            )
        ),
        LessonCategory(
            id = "hi_cat_2",
            language = AppLanguage.HINDI,
            title = "Daily Conversations & Shopping",
            nativeTitle = "दैनिक बातचीत और खरीदारी",
            icon = "💬",
            description = "Ask names, bargain politely, ask for directions, and hold pleasant talks.",
            level = DifficultyLevel.BEGINNER,
            lessons = listOf(
                Lesson(
                    id = "hi_conv_1",
                    categoryId = "hi_cat_2",
                    title = "Meeting New People",
                    nativeTitle = "नए लोगों से परिचय",
                    summary = "Learn to introduce yourself and ask questions with confidence.",
                    phrases = hindiDailyConversationPhrases,
                    xpReward = 50
                ),
                Lesson(
                    id = "hi_conv_2",
                    categoryId = "hi_cat_2",
                    title = "Food & Travel Inquiries",
                    nativeTitle = "खान-पान और सफर",
                    summary = "Ordering delicious dishes and navigating transit stations in Hindi.",
                    phrases = hindiFoodTravelPhrases,
                    xpReward = 55
                )
            )
        ),

        // Marathi categories
        LessonCategory(
            id = "mr_cat_1",
            language = AppLanguage.MARATHI,
            title = "Marathi Greetings & Respect",
            nativeTitle = "अभिवादन आणि आदर",
            icon = "🚩",
            description = "Learn warm traditional Marathi phrases for home, travel, and social events.",
            level = DifficultyLevel.BEGINNER,
            lessons = listOf(
                Lesson(
                    id = "mr_greet_1",
                    categoryId = "mr_cat_1",
                    title = "Warm Welcomes & Goodbyes",
                    nativeTitle = "स्वागत आणि निरोप",
                    summary = "Namaskar, Dhanyavaad, Punha Bhetu and formal pleasantries.",
                    phrases = marathiGreetingsPhrases,
                    xpReward = 45
                )
            )
        ),
        LessonCategory(
            id = "mr_cat_2",
            language = AppLanguage.MARATHI,
            title = "Street & Market Conversations",
            nativeTitle = "दैनंदिन संभाषण व बाजारपेठ",
            icon = "🛍️",
            description = "Talk like a local in Mumbai, Pune, and Maharashtra markets.",
            level = DifficultyLevel.INTERMEDIATE,
            lessons = listOf(
                Lesson(
                    id = "mr_daily_1",
                    categoryId = "mr_cat_2",
                    title = "Everyday Questions & Prices",
                    nativeTitle = "रोजचे प्रश्न व भावविचारणी",
                    summary = "Asking for names, asking prices, and expressing understanding.",
                    phrases = marathiDailyConversationPhrases,
                    xpReward = 50
                )
            )
        ),

        // English categories
        LessonCategory(
            id = "en_cat_1",
            language = AppLanguage.ENGLISH,
            title = "Polite Professional English",
            nativeTitle = "विनम्र व्यावसायिक इंग्रजी",
            icon = "💼",
            description = "Impress colleagues and international friends with natural, fluent phrasing.",
            level = DifficultyLevel.BEGINNER,
            lessons = listOf(
                Lesson(
                    id = "en_daily_1",
                    categoryId = "en_cat_1",
                    title = "Polite Requests & Greetings",
                    nativeTitle = "विनम्र विनंत्या आणि अभिवादन",
                    summary = "Key polite phrases used in meetings, interviews, and polite conversation.",
                    phrases = englishGreetingsPhrases,
                    xpReward = 45
                ),
                Lesson(
                    id = "en_daily_2",
                    categoryId = "en_cat_1",
                    title = "Fluent Idiomatic Expressions",
                    nativeTitle = "सहज व अस्खलित संभाषण",
                    summary = "Sound natural with common idioms like 'touch base' and 'total sense'.",
                    phrases = englishFluencyPhrases,
                    xpReward = 50
                )
            )
        )
    )

    // Quizzes for each language
    val quizzes: List<QuizQuestion> = listOf(
        // Hindi
        QuizQuestion(
            id = "quiz_hi_1",
            language = AppLanguage.HINDI,
            question = "How do you say 'Thank you' respectfully in Hindi?",
            phraseToPlay = "धन्यवाद",
            options = listOf("सुप्रभात", "धन्यवाद", "अलविदा", "नमस्ते"),
            correctIndex = 1,
            explanation = "'धन्यवाद' (Dhanyavaad) means Thank you in Hindi."
        ),
        QuizQuestion(
            id = "quiz_hi_2",
            language = AppLanguage.HINDI,
            question = "What does 'आपका नाम क्या है?' translate to?",
            phraseToPlay = "आपका नाम क्या है?",
            options = listOf("Where do you live?", "What is your name?", "How are you?", "What time is it?"),
            correctIndex = 1,
            explanation = "'आपका नाम क्या है?' means 'What is your name?'."
        ),
        QuizQuestion(
            id = "quiz_hi_3",
            language = AppLanguage.HINDI,
            question = "Which phrase is used to wish someone 'Good morning' in Hindi?",
            phraseToPlay = "सुप्रभात",
            options = listOf("सुप्रभात", "शुभ रात्रि", "माफ़ कीजिये", "नमस्ते"),
            correctIndex = 0,
            explanation = "'सुप्रभात' (Suprabhaat) means Good morning."
        ),
        QuizQuestion(
            id = "quiz_hi_4",
            language = AppLanguage.HINDI,
            question = "Translate: 'The food is very delicious'.",
            phraseToPlay = "खाना बहुत स्वादिष्ट है",
            options = listOf("मुझे भूख लगी है", "खाना बहुत स्वादिष्ट है", "रेलवे स्टेशन कहाँ है?", "पानी ठंडा है"),
            correctIndex = 1,
            explanation = "'खाना बहुत स्वादिष्ट है' translates to 'The food is very delicious'."
        ),

        // Marathi
        QuizQuestion(
            id = "quiz_mr_1",
            language = AppLanguage.MARATHI,
            question = "How do you politely ask 'How are you?' in Marathi?",
            phraseToPlay = "तुम्ही कसे आहात?",
            options = listOf("तुम्ही कुठे राहता?", "तुमचे नाव काय आहे?", "तुम्ही कसे आहात?", "पुन्हा भेटू"),
            correctIndex = 2,
            explanation = "'तुम्ही कसे आहात?' (Tumhi kase aahaat?) means 'How are you?' in Marathi."
        ),
        QuizQuestion(
            id = "quiz_mr_2",
            language = AppLanguage.MARATHI,
            question = "What is the meaning of 'पुन्हा भेटू' (Punha Bhetu)?",
            phraseToPlay = "पुन्हा भेटू",
            options = listOf("Welcome", "See you again / Goodbye", "Good morning", "Excuse me"),
            correctIndex = 1,
            explanation = "'पुन्हा भेटू' means 'See you again' when parting."
        ),
        QuizQuestion(
            id = "quiz_mr_3",
            language = AppLanguage.MARATHI,
            question = "Which Marathi phrase means 'Good Morning'?",
            phraseToPlay = "शुभ सकाळ",
            options = listOf("शुभ रात्री", "शुभ सकाळ", "नमस्कार", "आभारी आहे"),
            correctIndex = 1,
            explanation = "'शुभ सकाळ' (Shubh Sakaal) means Good Morning in Marathi."
        ),

        // English
        QuizQuestion(
            id = "quiz_en_1",
            language = AppLanguage.ENGLISH,
            question = "Which expression means 'Let's briefly talk or follow up tomorrow'?",
            phraseToPlay = "Let's touch base tomorrow",
            options = listOf("Let's call it a day", "Let's touch base tomorrow", "Never mind", "Take your time"),
            correctIndex = 1,
            explanation = "'Touch base' is a common professional phrase meaning to connect or follow up."
        ),
        QuizQuestion(
            id = "quiz_en_2",
            language = AppLanguage.ENGLISH,
            question = "What is the most polite way to ask for assistance?",
            phraseToPlay = "Could you please help me?",
            options = listOf("Help me now", "Could you please help me?", "Where is it", "You do this"),
            correctIndex = 1,
            explanation = "'Could you please help me?' uses modal polite framing."
        )
    )

    // Badges & Achievements
    val achievements: List<AchievementBadge> = listOf(
        AchievementBadge(
            id = "badge_starter",
            title = "First Words",
            description = "Completed your first lesson in SpeakEasy",
            icon = "🌱",
            isUnlocked = true,
            requiredXp = 20
        ),
        AchievementBadge(
            id = "badge_streak_5",
            title = "5-Day Streak",
            description = "Maintained learning momentum for 5 consecutive days",
            icon = "🔥",
            isUnlocked = true,
            requiredXp = 100
        ),
        AchievementBadge(
            id = "badge_polyglot",
            title = "Tri-Lingual Explorer",
            description = "Practiced lessons in English, Hindi, and Marathi",
            icon = "🌐",
            isUnlocked = true,
            requiredXp = 250
        ),
        AchievementBadge(
            id = "badge_speaker",
            title = "Pronunciation Pro",
            description = "Scored 90%+ accuracy in 5 speaking exercises",
            icon = "🎙️",
            isUnlocked = true,
            requiredXp = 350
        ),
        AchievementBadge(
            id = "badge_quiz_master",
            title = "Quiz Master",
            description = "Achieve 500 XP and ace 10 language quizzes",
            icon = "👑",
            isUnlocked = false,
            requiredXp = 500
        )
    )

    // Speaking practice exercise pool
    val speakingPractices = listOf(
        Phrase(
            id = "spk_1",
            targetText = "नमस्ते, आप कैसे हैं?",
            scriptText = "नमस्ते, आप कैसे हैं?",
            transliteration = "Namaste, aap kaise hain?",
            englishMeaning = "Hello, how are you?",
            nativeMeaning = "सादर प्रणाम, आप कैसे हैं?",
            exampleTarget = "नमस्ते! मैं बिल्कुल ठीक हूँ।",
            exampleMeaning = "Hello! I am completely fine.",
            audioHint = "na-mas-tay, aap kay-say hain"
        ),
        Phrase(
            id = "spk_2",
            targetText = "नमस्कार, तुमचे नाव काय आहे?",
            scriptText = "नमस्कार, तुमचे नाव काय आहे?",
            transliteration = "Namaskar, tumche naav kaay aahe?",
            englishMeaning = "Hello, what is your name?",
            nativeMeaning = "अभिवादन, आपले नाव काय आहे?",
            exampleTarget = "नमस्कार, माझे नाव अनिकेत आहे.",
            exampleMeaning = "Hello, my name is Aniket.",
            audioHint = "na-mas-kaar, tum-chay naav kaay aa-hay"
        ),
        Phrase(
            id = "spk_3",
            targetText = "Pleasure to meet you today!",
            scriptText = "Pleasure to meet you today!",
            transliteration = "प्लेझर टू मीट यू टुडे!",
            englishMeaning = "Delighted to meet you today!",
            nativeMeaning = "आज आपसे मिलकर बहुत खुशी हुई!",
            exampleTarget = "It's an absolute pleasure to meet you today!",
            exampleMeaning = "आज आपसे मिलकर वाकई बहुत खुशी हुई!",
            audioHint = "pleh-zhur to meet yoo to-day"
        ),
        Phrase(
            id = "spk_4",
            targetText = "आपकी मदद के लिए धन्यवाद।",
            scriptText = "आपकी मदद के लिए धन्यवाद।",
            transliteration = "Aapki madad ke liye dhanyavaad.",
            englishMeaning = "Thank you for your help.",
            nativeMeaning = "सहायता हेतु आभार।",
            exampleTarget = "बहुत-बहुत धन्यवाद, आपका दिन शुभ हो।",
            exampleMeaning = "Thank you very much, have a nice day.",
            audioHint = "aap-kee ma-dad kay li-ye dhan-ya-vaad"
        ),
        Phrase(
            id = "spk_5",
            targetText = "उद्या सकाळी पुन्हा भेटू!",
            scriptText = "उद्या सकाळी पुन्हा भेटू!",
            transliteration = "Udya sakaali punha bhetu!",
            englishMeaning = "See you again tomorrow morning!",
            nativeMeaning = "उद्या सकाळी परत भेटू!",
            exampleTarget = "चालेल दादा, उद्या सकाळी पुन्हा भेटू!",
            exampleMeaning = "Sure brother, see you again tomorrow morning!",
            audioHint = "ud-yaa sa-kaa-lee pun-ha bhay-too"
        )
    )
}
