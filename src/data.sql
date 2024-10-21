DELETE FROM lesson;
DELETE FROM lang;

INSERT INTO lang (id, name, description, code) VALUES (1, "French", "The French language is a Romance language that is spoken by approximately 220 million people worldwide as a first or second language.", "fr");
INSERT INTO lang (id, name, description, code) VALUES (2, "Russian", "Russian is a Slavic language spoken by approximately 258 million people worldwide and is an official language in Russia, Belarus, Kazakhstan, and Kyrgyzstan.", "ru");
INSERT INTO lang (id, name, description, code) VALUES (3, "English", "English is a West Germanic language that is spoken by over 1.5 billion people worldwide, making it the second most widely spoken language, and is commonly used as a lingua franca in many parts of the world.", "gb");

INSERT INTO lesson (id, name, slug, lang_id) VALUES (1, "Урок “Зелёные технологии”", "green", 2);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (2, "Урок “Преимущества тревожности”", "advantages", 2);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (3, "Урок “Самая пунктуальная”", "most", 2);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (4, "Урок “Глаголы движения со «Смешариками»“", "glagol", 2);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (5, "Урок «На соревнованиях по триатлону»", "triatlon", 2);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (6, "Урок “Какое загадать желание в день рождения?”", "wish", 2);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (7, "Разговорник русского языка: в кафе или ресторане", "cafe", 2);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (8, "Урок “Как пройти к галерее?”", "galery", 2);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (9, "Популярные русские фразеологизмы (2022)", "phrases", 2);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (10, "7 способов сказать “пожалуйста” по-русски", "please", 2);

INSERT INTO lesson (id, name, slug, lang_id) VALUES (11, "Знакомство", "greeting", 1);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (12, "Пожалуйста и спасибо", "thanx", 1);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (13, "Празднования и вечеринки", "congrast", 1);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (14, "Мир на земле", "world", 1);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (15, "Чувства и эмоции", "feelings", 1);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (16, "Дни недели", "week", 1);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (17, "Месяцы года", "months", 1);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (18, "Числа от 1 до 10", "1-10", 1);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (19, "Числа от 11 до 20", "11-20", 1);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (20, "Солнечная система", "sun", 1);

INSERT INTO lesson (id, name, slug, lang_id) VALUES (21, "Free time activities", "freetime", 3);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (22, "Character qualities", "qualities", 3);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (23, "Grammar in Use", "grammar", 3);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (24, "Appearance", "appearance", 3);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (25, "Teenage fashion in the UK", "fashion", 3);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (26, "Put an end to discrimination!", "discr", 3);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (27, "The recycling loop", "recycle", 3);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (28, "Spending money", "money", 3);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (29, "Hobbies and personalities", "hobbies", 3);
INSERT INTO lesson (id, name, slug, lang_id) VALUES (30, "The railway children", "railway", 3);