import { doSomething, resetCount } from '../basicLoop';
import { assert } from "chai"

describe('basicLoop', function(){
    beforeEach( () => {
        resetCount();
    })
    it('test ', function(){
        assert.equal(doSomething('Cerises,Apples'),175)
        assert.equal(doSomething('Cerises'),230)
        assert.equal(doSomething('Bananes'),380)
        assert.equal(doSomething('Bananes'),380)
    })
    it('test 2 ', function(){
        assert.equal(doSomething('Cerises'),75)
        assert.equal(doSomething('Apples'),175)
        assert.equal(doSomething('Cerises'),230)
        assert.equal(doSomething('Bananes'),380)
        assert.equal(doSomething('Pommes'),480)
        assert.equal(doSomething('Mele'),580)
    })
})