#include <stdio.h>
#include "pico/stdlib.h"
#include "hardware/i2c.h"
#include "hardware/adc.h"
#include <stdbool.h>

#define Configuration_register 0x00
#define Shunt_voltage_register 0x01
#define Bus_voltage_register 0x02
#define Power_register 0x03
#define Current_register 0x04
#define Calibration_register 0x05

#define SDA_pin 4
#define SDL_pin 5

void poll_voltage()
{
    i2c_init();
    uint8_t data[10];
}

int main()
{
    stdio_init_all();
    gpio_set_function(SDA_pin, GPIO_FUNC_I2C);
    gpio_set_function(SDL_pin, GPIO_FUNC_I2C);
    while (true)
    {
        printf("yooo");
        printf("Hello, world!\n");
        sleep_ms(1000);
    }
}