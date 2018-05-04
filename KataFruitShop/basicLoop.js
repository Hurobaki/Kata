const stdin = process.openStdin();
let sum = 0;

let dic = [
    {name: 'Apples', prix: 100, count: 0, countReduction: 3, reduction: 100},
    {name: 'Mele', prix: 100, count: 0, countReduction: 2, reduction: 50},
    {name: 'Pommes', prix: 100, count: 0, countReduction: -1, reduction: 0},
    {name: 'Cerises', prix: 75, count: 0, countReduction: 2, reduction: 20},
    {name: 'Bananes', prix: 150, count: 0, countReduction: 2, reduction: 150}
    ]

let nameDic = {'Pommes': dic[2], 'Apples': dic[0], 'Mele': dic[1], 'Cerises': dic[3], 'Bananes': dic[4]}

stdin.addListener("data", function (d) {
    console.log(doSomething(d.toString().trim()));
});

export function doSomething(message) {
    const fruits = message.split(',')
    for(let fruitName in fruits) {
        const fruit = nameDic[fruits[fruitName]]
        fruit.count++;
        if (fruit.count % fruit.countReduction === 0 && fruit.count !== 0) {
            sum -= fruit.reduction;
        }
        sum += fruit.prix
    }
    return sum;
}

export function resetCount() {
    sum = 0
    for (let fruit in nameDic) {
        nameDic[fruit].count = 0;
    }
}
