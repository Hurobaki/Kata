export function fizzBuzz(number){
    if(isFizz(number) && isBuzz(number))
        return 'FizzBuzz'

    if (isFizz(number))
        return 'Fizz'

    if (isBuzz(number))
        return 'Buzz'

    return number
}

function isFizz(number){
    if (number%3===0)
        return true
    return false
}
function isBuzz(number){
    if (number%5===0)
        return true
    return false
}
