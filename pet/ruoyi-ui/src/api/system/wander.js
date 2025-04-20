import request from '@/utils/request'

// 查询流浪动物列表
export function listWander(query) {
  return request({
    url: '/system/wander/list',
    method: 'get',
    params: query
  })
}

// 查询流浪动物详细
export function getWander(wanderId) {
  return request({
    url: '/system/wander/' + wanderId,
    method: 'get'
  })
}

// 新增流浪动物
export function addWander(data) {
  return request({
    url: '/system/wander',
    method: 'post',
    data: data
  })
}

// 修改流浪动物
export function updateWander(data) {
  return request({
    url: '/system/wander',
    method: 'put',
    data: data
  })
}

// 删除流浪动物
export function delWander(wanderId) {
  return request({
    url: '/system/wander/' + wanderId,
    method: 'delete'
  })
}
