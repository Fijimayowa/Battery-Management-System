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

#define R_SHUNT 0.01
void poll_voltage()
{
    i2c_init();
    uint8_t current_data, power_data, shunt_voltage, bus_voltage;
    i2c_read_register(INA219_ADDR, Current_register, &current_data);
    i2c_read_register(INA219_ADDR, Power_register, &power_data);
    i2c_read_register(INA219_ADDR, Shunt_voltage_register, &shunt_voltage);
    i2c_read_register(INA219_ADDR, Bus_voltage_register, &bus_voltage);
}

void thermal_model(){
    
}

int main()
{
    stdio_init_all();
    gpio_set_function(SDA_pin, GPIO_FUNC_I2C);
    gpio_set_function(SDL_pin, GPIO_FUNC_I2C);
    double expected_current = 600, calbration = expected_current / 32768;
    double real_calbration = 0.04096 / (calbration * R_SHUNT);
    if (expected_current < 1)
    {
        expected_current = 1d;
    }
    i2c_write_register(INA219_ADDR, Calibration_register, real_calbration);
    while (true)
    {
        printf("yooo");
        printf("Hello, world!\n");
        sleep_ms(1000);
    }
}