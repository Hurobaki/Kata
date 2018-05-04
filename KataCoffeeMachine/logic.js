export class Logic{

    constructor(drinkMaker){
        this._drinkMaker=drinkMaker;
    }
    generateOrderFromPad(order){
        const drinkChoice= {
            'tea':
                {cost:0.4, order:'T'},
            'chocolate':
                {cost:0.5, order:'H'},
            'coffee':
                {cost:0.6, order:'C'},
            'orange':
                {cost:0.6, order:'O'}
        };
        let result='';
        if(drinkChoice[order.drink].cost <= order.money){
            result+=drinkChoice[order.drink].order;
            order.extra ? result+='h' : null;
            order.sugar ? result+=`:${order.sugar}:0` : result+='::';
            this._drinkMaker.Make(result);
        }
        else
            this._drinkMaker.Make(`M:Not enough money ${+(drinkChoice[order.drink].cost-order.money).toFixed(1)}`);
    }
}