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

#define INA219_ADDR 0x40

void poll_voltage()
{
    i2c_init();
    uint8_t current_data, power_data;
    i2c_read_register(INA219_ADDR, Current_register, &current_data);
    i2c_read_register(INA219_ADDR, Power_register, &power_data);
}

int main()
{
    stdio_init_all();
    gpio_set_function(SDA_pin, GPIO_FUNC_I2C);
    gpio_set_function(SDL_pin, GPIO_FUNC_I2C);
    double expected_current = 600, calbration = expected_current / 32768;
    while (true)
    {
        printf("yooo");
        printf("Hello, world!\n");
        sleep_ms(1000);
    }
}