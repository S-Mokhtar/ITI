<?php

$item_list = [
    [
        'id'=>1, 'name'=> 'Share Box', 'price'=> 130.00, 'image'=> 'share-box.jpg',
        'description'=> "Pick 2 sandwiches from Big Mac (beef/chicken) and McChicken + 2 sandwiches from Beefburger, cheeseburger and Chicken MacDo + 2 regular fries + 1 liter Coke"
    ],
    [
        'id'=>2, 'name'=> 'Big Tasty Sauce', 'price'=> 5.00, 'image'=> 'big-tasty-sauce.jpg',
        'description'=> "The distinctive flavour of Big Tasty sauce comes from smoke flavourings, spices and garlic"
    ],
    [
        'id'=>3, 'name'=> 'Grand Share Box', 'price'=> 183.00, 'image'=> 'grand-share-box.jpg',
        'description'=> "Pick 2 sandwiches from the juicy Big Tasty (beef/chicken) and delicious Grand Chicken (premier/spicy) + 2 sandwiches from Beefburger, cheeseburger and Chicken MACDO + 2 regular fries + 1 liter Coke"
    ],
];

header('Content-type: application.json');
echo json_encode($item_list);