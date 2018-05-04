import {Logic} from '../logic';
import {DrinkMakerMock} from './logic_mock'

var assert = require('assert');

describe('Coffee machine', function () {
    let logic;
    let drinkMaker;
    beforeEach(function () {
        drinkMaker = new DrinkMakerMock();
        logic = new Logic(drinkMaker);
    }),
    it("should return the string 'M:Not enough money 0.1' when the logic receives input object {drink:'tea', sugar:1, money:0.3}", function () {
        logic.generateOrderFromPad({drink: 'tea', sugar: 1, money: 0.3});
        assert.equal(drinkMaker.lastOrder, 'M:Not enough money 0.1');
    }),
    it("should return the string 'H::' when the logic receives input object {drink:'chocolate', sugar:0, money:0.5}", function () {
        logic.generateOrderFromPad({drink: 'chocolate', sugar: 0, money: 0.5});
        assert.equal(drinkMaker.lastOrder, 'H::');
    }),
    it("should return the string 'C:2:0' when the logic receives input object {drink:'coffee', sugar:2, money:0.6}", () => {
        logic.generateOrderFromPad({drink: 'coffee', sugar: 2, money: 0.6});
        assert.equal(drinkMaker.lastOrder, 'C:2:0');
    }),
    it("should return the string 'C:3:0' when the logic receives input object {drink:'coffee', sugar:3, money:0.6}", () => {
        logic.generateOrderFromPad({drink: 'coffee', sugar: 3, money: 0.6});
        assert.equal(drinkMaker.lastOrder, 'C:3:0');
    }),
    it("should return the string 'O::' when the logic receives input object {drink:'orange', sugar:0, money:0.6}", () => {
        logic.generateOrderFromPad({drink: 'orange', sugar: 0, money: 0.6});
        assert.equal(drinkMaker.lastOrder, 'O::')
    }),
    it("should return the string 'Ch::' when the logic receives input object {drink:'coffee', sugar:0, money:0.6, extra:true}", () => {
        logic.generateOrderFromPad({drink: 'coffee', sugar: 0, money: 0.6, extra: true});
        assert.equal(drinkMaker.lastOrder, 'Ch::')
    }),
    it("should return the string 'Hh:1:0' when the logic receives input object {drink:'chocolate', sugar:1, money:0.5, extra:true}", () => {
        logic.generateOrderFromPad({drink: 'chocolate', sugar: 1, money: 0.5, extra: true})
        assert.equal(drinkMaker.lastOrder, 'Hh:1:0')
    }),
    it("should return the string 'Th:2:0' when the logic receives input object {drink:'tea', sugar:2, money:0.4, extra: true}", () => {
        logic.generateOrderFromPad({drink: 'tea', sugar: 2, money: 0.4, extra: true})
        assert.equal(drinkMaker.lastOrder, 'Th:2:0')
    })
});
